/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.schemagen;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleAdsGqlSchemaGen {
    private final List<String> schemas = List.of(
            "accessible_bidding_strategy", "account_budget", "account_budget_proposal", "account_link", "ad_group", "ad_group_ad", "ad_group_ad_asset_combination_view", "ad_group_ad_asset_view", "ad_group_ad_label", "ad_group_asset", "ad_group_asset_set", "ad_group_audience_view", "ad_group_bid_modifier", "ad_group_criterion", "ad_group_criterion_customizer", "ad_group_criterion_label", "ad_group_criterion_simulation", "ad_group_customizer", "ad_group_extension_setting", "ad_group_feed", "ad_group_label", "ad_group_simulation", "ad_parameter", "ad_schedule_view", "age_range_view", "android_privacy_shared_key_google_ad_group", "android_privacy_shared_key_google_campaign", "android_privacy_shared_key_google_network_type", "asset", "asset_field_type_view", "asset_group", "asset_group_asset", "asset_group_listing_group_filter", "asset_group_product_group_view", "asset_group_signal", "asset_group_top_combination_view", "asset_set", "asset_set_asset", "asset_set_type_view", "audience", "batch_job", "bidding_data_exclusion", "bidding_seasonality_adjustment", "bidding_strategy", "bidding_strategy_simulation", "billing_setup", "call_view", "campaign", "campaign_asset", "campaign_asset_set", "campaign_audience_view", "campaign_bid_modifier", "campaign_budget", "campaign_conversion_goal", "campaign_criterion", "campaign_customizer", "campaign_draft", "campaign_extension_setting", "campaign_feed", "campaign_group", "campaign_label", "campaign_lifecycle_goal", "campaign_search_term_insight", "campaign_shared_set", "campaign_simulation", "carrier_constant", "change_event", "change_status", "click_view", "combined_audience", "conversion_action", "conversion_custom_variable", "conversion_goal_campaign_config", "conversion_value_rule", "conversion_value_rule_set", "currency_constant", "custom_audience", "custom_conversion_goal", "custom_interest", "customer", "customer_asset", "customer_asset_set", "customer_client", "customer_client_link", "customer_conversion_goal", "customer_customizer", "customer_extension_setting", "customer_feed", "customer_label", "customer_lifecycle_goal", "customer_manager_link", "customer_negative_criterion", "customer_search_term_insight", "customer_user_access", "customer_user_access_invitation", "customizer_attribute", "detail_placement_view", "detailed_demographic", "display_keyword_view", "distance_view", "domain_category", "dynamic_search_ads_search_term_view", "expanded_landing_page_view", "experiment", "experiment_arm", "extension_feed_item", "feed", "feed_item", "feed_item_set", "feed_item_set_link", "feed_item_target", "feed_mapping", "feed_placeholder_view", "gender_view", "geo_target_constant", "geographic_view", "group_placement_view", "hotel_group_view", "hotel_performance_view", "hotel_reconciliation", "income_range_view", "keyword_plan", "keyword_plan_ad_group", "keyword_plan_ad_group_keyword", "keyword_plan_campaign", "keyword_plan_campaign_keyword", "keyword_theme_constant", "keyword_view", "label", "landing_page_view", "language_constant", "lead_form_submission_data", "life_event", "local_services_employee", "local_services_lead", "local_services_lead_conversation", "local_services_verification_artifact", "location_view", "managed_placement_view", "media_file", "mobile_app_category_constant", "mobile_device_constant", "offline_conversion_upload_client_summary", "offline_user_data_job", "operating_system_version_constant", "paid_organic_search_term_view", "parental_status_view", "per_store_view", "product_category_constant", "product_group_view", "product_link", "product_link_invitation", "qualifying_question", "recommendation", "recommendation_subscription", "remarketing_action", "search_term_view", "shared_criterion", "shared_set", "shopping_performance_view", "smart_campaign_search_term_view", "smart_campaign_setting", "third_party_app_analytics_link", "topic_constant", "topic_view", "travel_activity_group_view", "travel_activity_performance_view", "user_interest", "user_list", "user_location_view", "video", "webpage_view"
    );
    private final File tempFolder;

    public GoogleAdsGqlSchemaGen() {
        this.tempFolder = new File("./tmp/gads-schema-gen");
        this.tempFolder.mkdirs();
    }

    private Set<String> loadSchemasAttributes() throws Exception {
        TreeSet<String> uniqueAttributes = new TreeSet<>();

        for (String schema : schemas) {
            List<String> attributes = getAttributesFromJsonSchema(schema);

            uniqueAttributes.addAll(attributes);
        }

        return uniqueAttributes;
    }

    public List<String> getAttributesFromJsonSchema(String schema) throws IOException {
        String url = "https://gaql-query-builder.uc.r.appspot.com/schemas/v16/" + schema + ".json";

        File cachedFile = new File(tempFolder, schema + ".json");

        if (cachedFile.exists()) {
            StringBuilder jsonContent = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(cachedFile))) {
                String line;
                while ((line = reader.readLine()) != null)
                    jsonContent.append(line);
            }
            return parseAttributesFromJson(jsonContent.toString());
        }

        return parseAttributesFromJson(
                downloadAndCacheJson(url, cachedFile)
        );
    }

    private String downloadAndCacheJson(String url, File cachedFile) throws IOException {
        StringBuilder jsonContent = new StringBuilder();
        URL jsonUrl = new URL(url);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(jsonUrl.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null)
                jsonContent.append(line);
        }

        String result = jsonContent.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cachedFile))) {
            writer.write(result);
        }
        return result;
    }

    private List<String> parseAttributesFromJson(String jsonContent) {
        JSONObject jsonObject = new JSONObject(jsonContent);
        JSONArray attributeArray = jsonObject.getJSONArray("attributes");
        List<String> attributes = new ArrayList<>();
        for (int i = 0; i < attributeArray.length(); i++)
            attributes.add(attributeArray.getString(i));

        return attributes;
    }

    private void generate() throws Exception {
        Set<String> attributes = loadSchemasAttributes();
        Map<String, ClassContainer> classContainersByClassName = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("([A-z-0-9_]+)\\.(.+)");

        for (String attribute : attributes) {
            Matcher m = pattern.matcher(attribute);

            if (!m.matches()) {
                System.out.println("Attribute not matched: " + attribute);
                continue;
            }

            String className = m.group(1);
            String attributeName = m.group(2);

            ClassContainer classContainer = classContainersByClassName.get(className);
            if (classContainer == null) {
                classContainer = new ClassContainer();
                classContainer.setClassName(className);
                classContainer.setAttributes(new TreeSet<>());
                classContainersByClassName.put(className, classContainer);
            }

            classContainer.getAttributes().add(attributeName);
        }

        String header = """
                package net.twobid.googleads.query;
                
                public class Gaql {
                """;

        ClassContainer tables = new ClassContainer();
        tables.setClassName("table");
        tables.setAttributes(new TreeSet<>(classContainersByClassName.keySet()));

        try (FileOutputStream fos = new FileOutputStream("Gaql.java")) {
            fos.write(header.getBytes());

            fos.write(tables.toString(false).getBytes());
            for (ClassContainer classContainer : classContainersByClassName.values()) {
                fos.write(classContainer.toString(true).getBytes());
            }

            fos.write("}".getBytes());
        }
    }

    private static String toCamelCase(String input) {
        String[] words = input.split("_");

        StringBuilder result = new StringBuilder(words[0].toLowerCase());
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            result.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1).toLowerCase());
        }

        return result.toString();
    }

    public static String toUpperCamelCase(String input) {
        String[] words = input.split("_");

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
        }

        return result.toString();
    }


    public static void main(String[] args) throws Exception {
        GoogleAdsGqlSchemaGen gen = new GoogleAdsGqlSchemaGen();
        gen.generate();
    }

    private static class ClassContainer {
        private String className;
        private TreeSet<String> attributes;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public TreeSet<String> getAttributes() {
            return attributes;
        }

        public void setAttributes(TreeSet<String> attributes) {
            this.attributes = attributes;
        }

        public String toString(boolean appendTables) {
            StringBuilder sb = new StringBuilder();
            sb.append("public static class ").append(toUpperCamelCase(className)).append(" {\n");

            for (String attribute : attributes) {
                String attributeName = attribute.replace(".", "_");
                sb.append("    public static final String ")
                        .append(toCamelCase(attributeName))
                        .append(" = \"")
                        .append(appendTables ? (className + "." +attribute) : attribute)
                        .append("\"")
                        .append(";\n");
            }

            sb.append("}\n\n");
            return sb.toString();
        }
    }
}
