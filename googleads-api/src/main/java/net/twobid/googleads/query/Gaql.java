/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.query;

public class Gaql {
    public static class Table {
        public static final String accessibleBiddingStrategy = "accessible_bidding_strategy";
        public static final String accountBudget = "account_budget";
        public static final String accountBudgetProposal = "account_budget_proposal";
        public static final String accountLink = "account_link";
        public static final String adGroup = "ad_group";
        public static final String adGroupAd = "ad_group_ad";
        public static final String adGroupAdAssetCombinationView = "ad_group_ad_asset_combination_view";
        public static final String adGroupAdAssetView = "ad_group_ad_asset_view";
        public static final String adGroupAdLabel = "ad_group_ad_label";
        public static final String adGroupAsset = "ad_group_asset";
        public static final String adGroupAssetSet = "ad_group_asset_set";
        public static final String adGroupAudienceView = "ad_group_audience_view";
        public static final String adGroupBidModifier = "ad_group_bid_modifier";
        public static final String adGroupCriterion = "ad_group_criterion";
        public static final String adGroupCriterionCustomizer = "ad_group_criterion_customizer";
        public static final String adGroupCriterionLabel = "ad_group_criterion_label";
        public static final String adGroupCriterionSimulation = "ad_group_criterion_simulation";
        public static final String adGroupCustomizer = "ad_group_customizer";
        public static final String adGroupExtensionSetting = "ad_group_extension_setting";
        public static final String adGroupFeed = "ad_group_feed";
        public static final String adGroupLabel = "ad_group_label";
        public static final String adGroupSimulation = "ad_group_simulation";
        public static final String adParameter = "ad_parameter";
        public static final String adScheduleView = "ad_schedule_view";
        public static final String ageRangeView = "age_range_view";
        public static final String androidPrivacySharedKeyGoogleAdGroup = "android_privacy_shared_key_google_ad_group";
        public static final String androidPrivacySharedKeyGoogleCampaign = "android_privacy_shared_key_google_campaign";
        public static final String androidPrivacySharedKeyGoogleNetworkType = "android_privacy_shared_key_google_network_type";
        public static final String asset = "asset";
        public static final String assetFieldTypeView = "asset_field_type_view";
        public static final String assetGroup = "asset_group";
        public static final String assetGroupAsset = "asset_group_asset";
        public static final String assetGroupListingGroupFilter = "asset_group_listing_group_filter";
        public static final String assetGroupProductGroupView = "asset_group_product_group_view";
        public static final String assetGroupSignal = "asset_group_signal";
        public static final String assetGroupTopCombinationView = "asset_group_top_combination_view";
        public static final String assetSet = "asset_set";
        public static final String assetSetAsset = "asset_set_asset";
        public static final String assetSetTypeView = "asset_set_type_view";
        public static final String audience = "audience";
        public static final String batchJob = "batch_job";
        public static final String biddingDataExclusion = "bidding_data_exclusion";
        public static final String biddingSeasonalityAdjustment = "bidding_seasonality_adjustment";
        public static final String biddingStrategy = "bidding_strategy";
        public static final String biddingStrategySimulation = "bidding_strategy_simulation";
        public static final String billingSetup = "billing_setup";
        public static final String callView = "call_view";
        public static final String campaign = "campaign";
        public static final String campaignAsset = "campaign_asset";
        public static final String campaignAssetSet = "campaign_asset_set";
        public static final String campaignAudienceView = "campaign_audience_view";
        public static final String campaignBidModifier = "campaign_bid_modifier";
        public static final String campaignBudget = "campaign_budget";
        public static final String campaignConversionGoal = "campaign_conversion_goal";
        public static final String campaignCriterion = "campaign_criterion";
        public static final String campaignCustomizer = "campaign_customizer";
        public static final String campaignDraft = "campaign_draft";
        public static final String campaignExtensionSetting = "campaign_extension_setting";
        public static final String campaignFeed = "campaign_feed";
        public static final String campaignGroup = "campaign_group";
        public static final String campaignLabel = "campaign_label";
        public static final String campaignLifecycleGoal = "campaign_lifecycle_goal";
        public static final String campaignSearchTermInsight = "campaign_search_term_insight";
        public static final String campaignSharedSet = "campaign_shared_set";
        public static final String campaignSimulation = "campaign_simulation";
        public static final String carrierConstant = "carrier_constant";
        public static final String changeEvent = "change_event";
        public static final String changeStatus = "change_status";
        public static final String clickView = "click_view";
        public static final String combinedAudience = "combined_audience";
        public static final String conversionAction = "conversion_action";
        public static final String conversionCustomVariable = "conversion_custom_variable";
        public static final String conversionGoalCampaignConfig = "conversion_goal_campaign_config";
        public static final String conversionValueRule = "conversion_value_rule";
        public static final String conversionValueRuleSet = "conversion_value_rule_set";
        public static final String currencyConstant = "currency_constant";
        public static final String customAudience = "custom_audience";
        public static final String customConversionGoal = "custom_conversion_goal";
        public static final String customInterest = "custom_interest";
        public static final String customer = "customer";
        public static final String customerAsset = "customer_asset";
        public static final String customerAssetSet = "customer_asset_set";
        public static final String customerClient = "customer_client";
        public static final String customerClientLink = "customer_client_link";
        public static final String customerConversionGoal = "customer_conversion_goal";
        public static final String customerCustomizer = "customer_customizer";
        public static final String customerExtensionSetting = "customer_extension_setting";
        public static final String customerFeed = "customer_feed";
        public static final String customerLabel = "customer_label";
        public static final String customerLifecycleGoal = "customer_lifecycle_goal";
        public static final String customerManagerLink = "customer_manager_link";
        public static final String customerNegativeCriterion = "customer_negative_criterion";
        public static final String customerSearchTermInsight = "customer_search_term_insight";
        public static final String customerUserAccess = "customer_user_access";
        public static final String customerUserAccessInvitation = "customer_user_access_invitation";
        public static final String customizerAttribute = "customizer_attribute";
        public static final String detailPlacementView = "detail_placement_view";
        public static final String detailedDemographic = "detailed_demographic";
        public static final String displayKeywordView = "display_keyword_view";
        public static final String distanceView = "distance_view";
        public static final String domainCategory = "domain_category";
        public static final String dynamicSearchAdsSearchTermView = "dynamic_search_ads_search_term_view";
        public static final String expandedLandingPageView = "expanded_landing_page_view";
        public static final String experiment = "experiment";
        public static final String experimentArm = "experiment_arm";
        public static final String extensionFeedItem = "extension_feed_item";
        public static final String feed = "feed";
        public static final String feedItem = "feed_item";
        public static final String feedItemSet = "feed_item_set";
        public static final String feedItemSetLink = "feed_item_set_link";
        public static final String feedItemTarget = "feed_item_target";
        public static final String feedMapping = "feed_mapping";
        public static final String feedPlaceholderView = "feed_placeholder_view";
        public static final String genderView = "gender_view";
        public static final String geoTargetConstant = "geo_target_constant";
        public static final String geographicView = "geographic_view";
        public static final String groupPlacementView = "group_placement_view";
        public static final String hotelGroupView = "hotel_group_view";
        public static final String hotelPerformanceView = "hotel_performance_view";
        public static final String hotelReconciliation = "hotel_reconciliation";
        public static final String incomeRangeView = "income_range_view";
        public static final String keywordPlan = "keyword_plan";
        public static final String keywordPlanAdGroup = "keyword_plan_ad_group";
        public static final String keywordPlanAdGroupKeyword = "keyword_plan_ad_group_keyword";
        public static final String keywordPlanCampaign = "keyword_plan_campaign";
        public static final String keywordPlanCampaignKeyword = "keyword_plan_campaign_keyword";
        public static final String keywordThemeConstant = "keyword_theme_constant";
        public static final String keywordView = "keyword_view";
        public static final String label = "label";
        public static final String landingPageView = "landing_page_view";
        public static final String languageConstant = "language_constant";
        public static final String leadFormSubmissionData = "lead_form_submission_data";
        public static final String lifeEvent = "life_event";
        public static final String localServicesEmployee = "local_services_employee";
        public static final String localServicesLead = "local_services_lead";
        public static final String localServicesLeadConversation = "local_services_lead_conversation";
        public static final String localServicesVerificationArtifact = "local_services_verification_artifact";
        public static final String locationView = "location_view";
        public static final String managedPlacementView = "managed_placement_view";
        public static final String mediaFile = "media_file";
        public static final String mobileAppCategoryConstant = "mobile_app_category_constant";
        public static final String mobileDeviceConstant = "mobile_device_constant";
        public static final String offlineConversionUploadClientSummary = "offline_conversion_upload_client_summary";
        public static final String offlineUserDataJob = "offline_user_data_job";
        public static final String operatingSystemVersionConstant = "operating_system_version_constant";
        public static final String paidOrganicSearchTermView = "paid_organic_search_term_view";
        public static final String parentalStatusView = "parental_status_view";
        public static final String perStoreView = "per_store_view";
        public static final String productCategoryConstant = "product_category_constant";
        public static final String productGroupView = "product_group_view";
        public static final String productLink = "product_link";
        public static final String productLinkInvitation = "product_link_invitation";
        public static final String qualifyingQuestion = "qualifying_question";
        public static final String recommendation = "recommendation";
        public static final String recommendationSubscription = "recommendation_subscription";
        public static final String remarketingAction = "remarketing_action";
        public static final String searchTermView = "search_term_view";
        public static final String sharedCriterion = "shared_criterion";
        public static final String sharedSet = "shared_set";
        public static final String shoppingPerformanceView = "shopping_performance_view";
        public static final String smartCampaignSearchTermView = "smart_campaign_search_term_view";
        public static final String smartCampaignSetting = "smart_campaign_setting";
        public static final String thirdPartyAppAnalyticsLink = "third_party_app_analytics_link";
        public static final String topicConstant = "topic_constant";
        public static final String topicView = "topic_view";
        public static final String travelActivityGroupView = "travel_activity_group_view";
        public static final String travelActivityPerformanceView = "travel_activity_performance_view";
        public static final String userInterest = "user_interest";
        public static final String userList = "user_list";
        public static final String userLocationView = "user_location_view";
        public static final String video = "video";
        public static final String webpageView = "webpage_view";
    }

    public static class AccessibleBiddingStrategy {
        public static final String id = "accessible_bidding_strategy.id";
        public static final String maximizeConversionValueTargetRoas = "accessible_bidding_strategy.maximize_conversion_value.target_roas";
        public static final String maximizeConversionsTargetCpaMicros = "accessible_bidding_strategy.maximize_conversions.target_cpa_micros";
        public static final String name = "accessible_bidding_strategy.name";
        public static final String ownerCustomerId = "accessible_bidding_strategy.owner_customer_id";
        public static final String ownerDescriptiveName = "accessible_bidding_strategy.owner_descriptive_name";
        public static final String resourceName = "accessible_bidding_strategy.resource_name";
        public static final String targetCpaTargetCpaMicros = "accessible_bidding_strategy.target_cpa.target_cpa_micros";
        public static final String targetImpressionShareCpcBidCeilingMicros = "accessible_bidding_strategy.target_impression_share.cpc_bid_ceiling_micros";
        public static final String targetImpressionShareLocation = "accessible_bidding_strategy.target_impression_share.location";
        public static final String targetImpressionShareLocationFractionMicros = "accessible_bidding_strategy.target_impression_share.location_fraction_micros";
        public static final String targetRoasTargetRoas = "accessible_bidding_strategy.target_roas.target_roas";
        public static final String targetSpendCpcBidCeilingMicros = "accessible_bidding_strategy.target_spend.cpc_bid_ceiling_micros";
        public static final String targetSpendTargetSpendMicros = "accessible_bidding_strategy.target_spend.target_spend_micros";
        public static final String type = "accessible_bidding_strategy.type";
    }

    public static class AccountBudget {
        public static final String adjustedSpendingLimitMicros = "account_budget.adjusted_spending_limit_micros";
        public static final String adjustedSpendingLimitType = "account_budget.adjusted_spending_limit_type";
        public static final String amountServedMicros = "account_budget.amount_served_micros";
        public static final String approvedEndDateTime = "account_budget.approved_end_date_time";
        public static final String approvedEndTimeType = "account_budget.approved_end_time_type";
        public static final String approvedSpendingLimitMicros = "account_budget.approved_spending_limit_micros";
        public static final String approvedSpendingLimitType = "account_budget.approved_spending_limit_type";
        public static final String approvedStartDateTime = "account_budget.approved_start_date_time";
        public static final String billingSetup = "account_budget.billing_setup";
        public static final String id = "account_budget.id";
        public static final String name = "account_budget.name";
        public static final String notes = "account_budget.notes";
        public static final String pendingProposalAccountBudgetProposal = "account_budget.pending_proposal.account_budget_proposal";
        public static final String pendingProposalCreationDateTime = "account_budget.pending_proposal.creation_date_time";
        public static final String pendingProposalEndDateTime = "account_budget.pending_proposal.end_date_time";
        public static final String pendingProposalEndTimeType = "account_budget.pending_proposal.end_time_type";
        public static final String pendingProposalName = "account_budget.pending_proposal.name";
        public static final String pendingProposalNotes = "account_budget.pending_proposal.notes";
        public static final String pendingProposalProposalType = "account_budget.pending_proposal.proposal_type";
        public static final String pendingProposalPurchaseOrderNumber = "account_budget.pending_proposal.purchase_order_number";
        public static final String pendingProposalSpendingLimitMicros = "account_budget.pending_proposal.spending_limit_micros";
        public static final String pendingProposalSpendingLimitType = "account_budget.pending_proposal.spending_limit_type";
        public static final String pendingProposalStartDateTime = "account_budget.pending_proposal.start_date_time";
        public static final String proposedEndDateTime = "account_budget.proposed_end_date_time";
        public static final String proposedEndTimeType = "account_budget.proposed_end_time_type";
        public static final String proposedSpendingLimitMicros = "account_budget.proposed_spending_limit_micros";
        public static final String proposedSpendingLimitType = "account_budget.proposed_spending_limit_type";
        public static final String proposedStartDateTime = "account_budget.proposed_start_date_time";
        public static final String purchaseOrderNumber = "account_budget.purchase_order_number";
        public static final String resourceName = "account_budget.resource_name";
        public static final String status = "account_budget.status";
        public static final String totalAdjustmentsMicros = "account_budget.total_adjustments_micros";
    }

    public static class AccountBudgetProposal {
        public static final String accountBudget = "account_budget_proposal.account_budget";
        public static final String approvalDateTime = "account_budget_proposal.approval_date_time";
        public static final String approvedEndDateTime = "account_budget_proposal.approved_end_date_time";
        public static final String approvedEndTimeType = "account_budget_proposal.approved_end_time_type";
        public static final String approvedSpendingLimitMicros = "account_budget_proposal.approved_spending_limit_micros";
        public static final String approvedSpendingLimitType = "account_budget_proposal.approved_spending_limit_type";
        public static final String approvedStartDateTime = "account_budget_proposal.approved_start_date_time";
        public static final String billingSetup = "account_budget_proposal.billing_setup";
        public static final String creationDateTime = "account_budget_proposal.creation_date_time";
        public static final String id = "account_budget_proposal.id";
        public static final String proposalType = "account_budget_proposal.proposal_type";
        public static final String proposedEndDateTime = "account_budget_proposal.proposed_end_date_time";
        public static final String proposedEndTimeType = "account_budget_proposal.proposed_end_time_type";
        public static final String proposedName = "account_budget_proposal.proposed_name";
        public static final String proposedNotes = "account_budget_proposal.proposed_notes";
        public static final String proposedPurchaseOrderNumber = "account_budget_proposal.proposed_purchase_order_number";
        public static final String proposedSpendingLimitMicros = "account_budget_proposal.proposed_spending_limit_micros";
        public static final String proposedSpendingLimitType = "account_budget_proposal.proposed_spending_limit_type";
        public static final String proposedStartDateTime = "account_budget_proposal.proposed_start_date_time";
        public static final String resourceName = "account_budget_proposal.resource_name";
        public static final String status = "account_budget_proposal.status";
    }

    public static class AccountLink {
        public static final String accountLinkId = "account_link.account_link_id";
        public static final String resourceName = "account_link.resource_name";
        public static final String status = "account_link.status";
        public static final String thirdPartyAppAnalyticsAppAnalyticsProviderId = "account_link.third_party_app_analytics.app_analytics_provider_id";
        public static final String thirdPartyAppAnalyticsAppId = "account_link.third_party_app_analytics.app_id";
        public static final String thirdPartyAppAnalyticsAppVendor = "account_link.third_party_app_analytics.app_vendor";
        public static final String type = "account_link.type";
    }

    public static class AdGroup {
        public static final String adRotationMode = "ad_group.ad_rotation_mode";
        public static final String audienceSettingUseAudienceGrouped = "ad_group.audience_setting.use_audience_grouped";
        public static final String baseAdGroup = "ad_group.base_ad_group";
        public static final String campaign = "ad_group.campaign";
        public static final String cpcBidMicros = "ad_group.cpc_bid_micros";
        public static final String cpmBidMicros = "ad_group.cpm_bid_micros";
        public static final String cpvBidMicros = "ad_group.cpv_bid_micros";
        public static final String displayCustomBidDimension = "ad_group.display_custom_bid_dimension";
        public static final String effectiveCpcBidMicros = "ad_group.effective_cpc_bid_micros";
        public static final String effectiveTargetCpaMicros = "ad_group.effective_target_cpa_micros";
        public static final String effectiveTargetCpaSource = "ad_group.effective_target_cpa_source";
        public static final String effectiveTargetRoas = "ad_group.effective_target_roas";
        public static final String effectiveTargetRoasSource = "ad_group.effective_target_roas_source";
        public static final String excludedParentAssetFieldTypes = "ad_group.excluded_parent_asset_field_types";
        public static final String excludedParentAssetSetTypes = "ad_group.excluded_parent_asset_set_types";
        public static final String finalUrlSuffix = "ad_group.final_url_suffix";
        public static final String id = "ad_group.id";
        public static final String labels = "ad_group.labels";
        public static final String name = "ad_group.name";
        public static final String optimizedTargetingEnabled = "ad_group.optimized_targeting_enabled";
        public static final String percentCpcBidMicros = "ad_group.percent_cpc_bid_micros";
        public static final String primaryStatus = "ad_group.primary_status";
        public static final String primaryStatusReasons = "ad_group.primary_status_reasons";
        public static final String resourceName = "ad_group.resource_name";
        public static final String status = "ad_group.status";
        public static final String targetCpaMicros = "ad_group.target_cpa_micros";
        public static final String targetCpmMicros = "ad_group.target_cpm_micros";
        public static final String targetRoas = "ad_group.target_roas";
        public static final String targetingSettingTargetRestrictions = "ad_group.targeting_setting.target_restrictions";
        public static final String trackingUrlTemplate = "ad_group.tracking_url_template";
        public static final String type = "ad_group.type";
        public static final String urlCustomParameters = "ad_group.url_custom_parameters";
    }

    public static class AdGroupAd {
        public static final String actionItems = "ad_group_ad.action_items";
        public static final String adAddedByGoogleAds = "ad_group_ad.ad.added_by_google_ads";
        public static final String adAppAdDescriptions = "ad_group_ad.ad.app_ad.descriptions";
        public static final String adAppAdHeadlines = "ad_group_ad.ad.app_ad.headlines";
        public static final String adAppAdHtml5MediaBundles = "ad_group_ad.ad.app_ad.html5_media_bundles";
        public static final String adAppAdHtml5MediaBundlesAsset = "ad_group_ad.ad.app_ad.html5_media_bundles.asset";
        public static final String adAppAdImages = "ad_group_ad.ad.app_ad.images";
        public static final String adAppAdImagesAsset = "ad_group_ad.ad.app_ad.images.asset";
        public static final String adAppAdMandatoryAdText = "ad_group_ad.ad.app_ad.mandatory_ad_text";
        public static final String adAppAdYoutubeVideos = "ad_group_ad.ad.app_ad.youtube_videos";
        public static final String adAppAdYoutubeVideosAsset = "ad_group_ad.ad.app_ad.youtube_videos.asset";
        public static final String adAppEngagementAdDescriptions = "ad_group_ad.ad.app_engagement_ad.descriptions";
        public static final String adAppEngagementAdHeadlines = "ad_group_ad.ad.app_engagement_ad.headlines";
        public static final String adAppEngagementAdImages = "ad_group_ad.ad.app_engagement_ad.images";
        public static final String adAppEngagementAdImagesAsset = "ad_group_ad.ad.app_engagement_ad.images.asset";
        public static final String adAppEngagementAdVideos = "ad_group_ad.ad.app_engagement_ad.videos";
        public static final String adAppEngagementAdVideosAsset = "ad_group_ad.ad.app_engagement_ad.videos.asset";
        public static final String adAppPreRegistrationAdDescriptions = "ad_group_ad.ad.app_pre_registration_ad.descriptions";
        public static final String adAppPreRegistrationAdHeadlines = "ad_group_ad.ad.app_pre_registration_ad.headlines";
        public static final String adAppPreRegistrationAdImages = "ad_group_ad.ad.app_pre_registration_ad.images";
        public static final String adAppPreRegistrationAdImagesAsset = "ad_group_ad.ad.app_pre_registration_ad.images.asset";
        public static final String adAppPreRegistrationAdYoutubeVideos = "ad_group_ad.ad.app_pre_registration_ad.youtube_videos";
        public static final String adAppPreRegistrationAdYoutubeVideosAsset = "ad_group_ad.ad.app_pre_registration_ad.youtube_videos.asset";
        public static final String adCallAdBusinessName = "ad_group_ad.ad.call_ad.business_name";
        public static final String adCallAdCallTracked = "ad_group_ad.ad.call_ad.call_tracked";
        public static final String adCallAdConversionAction = "ad_group_ad.ad.call_ad.conversion_action";
        public static final String adCallAdConversionReportingState = "ad_group_ad.ad.call_ad.conversion_reporting_state";
        public static final String adCallAdCountryCode = "ad_group_ad.ad.call_ad.country_code";
        public static final String adCallAdDescription1 = "ad_group_ad.ad.call_ad.description1";
        public static final String adCallAdDescription2 = "ad_group_ad.ad.call_ad.description2";
        public static final String adCallAdDisableCallConversion = "ad_group_ad.ad.call_ad.disable_call_conversion";
        public static final String adCallAdHeadline1 = "ad_group_ad.ad.call_ad.headline1";
        public static final String adCallAdHeadline2 = "ad_group_ad.ad.call_ad.headline2";
        public static final String adCallAdPath1 = "ad_group_ad.ad.call_ad.path1";
        public static final String adCallAdPath2 = "ad_group_ad.ad.call_ad.path2";
        public static final String adCallAdPhoneNumber = "ad_group_ad.ad.call_ad.phone_number";
        public static final String adCallAdPhoneNumberVerificationUrl = "ad_group_ad.ad.call_ad.phone_number_verification_url";
        public static final String adDemandGenProductAdBreadcrumb1 = "ad_group_ad.ad.demand_gen_product_ad.breadcrumb1";
        public static final String adDemandGenProductAdBreadcrumb2 = "ad_group_ad.ad.demand_gen_product_ad.breadcrumb2";
        public static final String adDemandGenProductAdBusinessName = "ad_group_ad.ad.demand_gen_product_ad.business_name";
        public static final String adDemandGenProductAdCallToAction = "ad_group_ad.ad.demand_gen_product_ad.call_to_action";
        public static final String adDemandGenProductAdCallToActionAsset = "ad_group_ad.ad.demand_gen_product_ad.call_to_action.asset";
        public static final String adDemandGenProductAdDescription = "ad_group_ad.ad.demand_gen_product_ad.description";
        public static final String adDemandGenProductAdHeadline = "ad_group_ad.ad.demand_gen_product_ad.headline";
        public static final String adDemandGenProductAdLogoImage = "ad_group_ad.ad.demand_gen_product_ad.logo_image";
        public static final String adDemandGenProductAdLogoImageAsset = "ad_group_ad.ad.demand_gen_product_ad.logo_image.asset";
        public static final String adDevicePreference = "ad_group_ad.ad.device_preference";
        public static final String adDiscoveryCarouselAdBusinessName = "ad_group_ad.ad.discovery_carousel_ad.business_name";
        public static final String adDiscoveryCarouselAdCallToActionText = "ad_group_ad.ad.discovery_carousel_ad.call_to_action_text";
        public static final String adDiscoveryCarouselAdCarouselCards = "ad_group_ad.ad.discovery_carousel_ad.carousel_cards";
        public static final String adDiscoveryCarouselAdCarouselCardsAsset = "ad_group_ad.ad.discovery_carousel_ad.carousel_cards.asset";
        public static final String adDiscoveryCarouselAdDescription = "ad_group_ad.ad.discovery_carousel_ad.description";
        public static final String adDiscoveryCarouselAdHeadline = "ad_group_ad.ad.discovery_carousel_ad.headline";
        public static final String adDiscoveryCarouselAdLogoImage = "ad_group_ad.ad.discovery_carousel_ad.logo_image";
        public static final String adDiscoveryCarouselAdLogoImageAsset = "ad_group_ad.ad.discovery_carousel_ad.logo_image.asset";
        public static final String adDiscoveryMultiAssetAdBusinessName = "ad_group_ad.ad.discovery_multi_asset_ad.business_name";
        public static final String adDiscoveryMultiAssetAdCallToActionText = "ad_group_ad.ad.discovery_multi_asset_ad.call_to_action_text";
        public static final String adDiscoveryMultiAssetAdDescriptions = "ad_group_ad.ad.discovery_multi_asset_ad.descriptions";
        public static final String adDiscoveryMultiAssetAdHeadlines = "ad_group_ad.ad.discovery_multi_asset_ad.headlines";
        public static final String adDiscoveryMultiAssetAdLeadFormOnly = "ad_group_ad.ad.discovery_multi_asset_ad.lead_form_only";
        public static final String adDiscoveryMultiAssetAdLogoImages = "ad_group_ad.ad.discovery_multi_asset_ad.logo_images";
        public static final String adDiscoveryMultiAssetAdLogoImagesAsset = "ad_group_ad.ad.discovery_multi_asset_ad.logo_images.asset";
        public static final String adDiscoveryMultiAssetAdMarketingImages = "ad_group_ad.ad.discovery_multi_asset_ad.marketing_images";
        public static final String adDiscoveryMultiAssetAdMarketingImagesAsset = "ad_group_ad.ad.discovery_multi_asset_ad.marketing_images.asset";
        public static final String adDiscoveryMultiAssetAdPortraitMarketingImages = "ad_group_ad.ad.discovery_multi_asset_ad.portrait_marketing_images";
        public static final String adDiscoveryMultiAssetAdPortraitMarketingImagesAsset = "ad_group_ad.ad.discovery_multi_asset_ad.portrait_marketing_images.asset";
        public static final String adDiscoveryMultiAssetAdSquareMarketingImages = "ad_group_ad.ad.discovery_multi_asset_ad.square_marketing_images";
        public static final String adDiscoveryMultiAssetAdSquareMarketingImagesAsset = "ad_group_ad.ad.discovery_multi_asset_ad.square_marketing_images.asset";
        public static final String adDiscoveryVideoResponsiveAdBreadcrumb1 = "ad_group_ad.ad.discovery_video_responsive_ad.breadcrumb1";
        public static final String adDiscoveryVideoResponsiveAdBreadcrumb2 = "ad_group_ad.ad.discovery_video_responsive_ad.breadcrumb2";
        public static final String adDiscoveryVideoResponsiveAdBusinessName = "ad_group_ad.ad.discovery_video_responsive_ad.business_name";
        public static final String adDiscoveryVideoResponsiveAdCallToActions = "ad_group_ad.ad.discovery_video_responsive_ad.call_to_actions";
        public static final String adDiscoveryVideoResponsiveAdCallToActionsAsset = "ad_group_ad.ad.discovery_video_responsive_ad.call_to_actions.asset";
        public static final String adDiscoveryVideoResponsiveAdDescriptions = "ad_group_ad.ad.discovery_video_responsive_ad.descriptions";
        public static final String adDiscoveryVideoResponsiveAdHeadlines = "ad_group_ad.ad.discovery_video_responsive_ad.headlines";
        public static final String adDiscoveryVideoResponsiveAdLogoImages = "ad_group_ad.ad.discovery_video_responsive_ad.logo_images";
        public static final String adDiscoveryVideoResponsiveAdLogoImagesAsset = "ad_group_ad.ad.discovery_video_responsive_ad.logo_images.asset";
        public static final String adDiscoveryVideoResponsiveAdLongHeadlines = "ad_group_ad.ad.discovery_video_responsive_ad.long_headlines";
        public static final String adDiscoveryVideoResponsiveAdVideos = "ad_group_ad.ad.discovery_video_responsive_ad.videos";
        public static final String adDiscoveryVideoResponsiveAdVideosAsset = "ad_group_ad.ad.discovery_video_responsive_ad.videos.asset";
        public static final String adDisplayUploadAdDisplayUploadProductType = "ad_group_ad.ad.display_upload_ad.display_upload_product_type";
        public static final String adDisplayUploadAdMediaBundle = "ad_group_ad.ad.display_upload_ad.media_bundle";
        public static final String adDisplayUploadAdMediaBundleAsset = "ad_group_ad.ad.display_upload_ad.media_bundle.asset";
        public static final String adDisplayUrl = "ad_group_ad.ad.display_url";
        public static final String adExpandedDynamicSearchAdDescription = "ad_group_ad.ad.expanded_dynamic_search_ad.description";
        public static final String adExpandedDynamicSearchAdDescription2 = "ad_group_ad.ad.expanded_dynamic_search_ad.description2";
        public static final String adExpandedTextAdDescription = "ad_group_ad.ad.expanded_text_ad.description";
        public static final String adExpandedTextAdDescription2 = "ad_group_ad.ad.expanded_text_ad.description2";
        public static final String adExpandedTextAdHeadlinePart1 = "ad_group_ad.ad.expanded_text_ad.headline_part1";
        public static final String adExpandedTextAdHeadlinePart2 = "ad_group_ad.ad.expanded_text_ad.headline_part2";
        public static final String adExpandedTextAdHeadlinePart3 = "ad_group_ad.ad.expanded_text_ad.headline_part3";
        public static final String adExpandedTextAdPath1 = "ad_group_ad.ad.expanded_text_ad.path1";
        public static final String adExpandedTextAdPath2 = "ad_group_ad.ad.expanded_text_ad.path2";
        public static final String adFinalAppUrls = "ad_group_ad.ad.final_app_urls";
        public static final String adFinalMobileUrls = "ad_group_ad.ad.final_mobile_urls";
        public static final String adFinalUrlSuffix = "ad_group_ad.ad.final_url_suffix";
        public static final String adFinalUrls = "ad_group_ad.ad.final_urls";
        public static final String adHotelAd = "ad_group_ad.ad.hotel_ad";
        public static final String adId = "ad_group_ad.ad.id";
        public static final String adImageAdImageAssetAsset = "ad_group_ad.ad.image_ad.image_asset.asset";
        public static final String adImageAdImageUrl = "ad_group_ad.ad.image_ad.image_url";
        public static final String adImageAdMimeType = "ad_group_ad.ad.image_ad.mime_type";
        public static final String adImageAdName = "ad_group_ad.ad.image_ad.name";
        public static final String adImageAdPixelHeight = "ad_group_ad.ad.image_ad.pixel_height";
        public static final String adImageAdPixelWidth = "ad_group_ad.ad.image_ad.pixel_width";
        public static final String adImageAdPreviewImageUrl = "ad_group_ad.ad.image_ad.preview_image_url";
        public static final String adImageAdPreviewPixelHeight = "ad_group_ad.ad.image_ad.preview_pixel_height";
        public static final String adImageAdPreviewPixelWidth = "ad_group_ad.ad.image_ad.preview_pixel_width";
        public static final String adLegacyAppInstallAd = "ad_group_ad.ad.legacy_app_install_ad";
        public static final String adLegacyResponsiveDisplayAdAccentColor = "ad_group_ad.ad.legacy_responsive_display_ad.accent_color";
        public static final String adLegacyResponsiveDisplayAdAllowFlexibleColor = "ad_group_ad.ad.legacy_responsive_display_ad.allow_flexible_color";
        public static final String adLegacyResponsiveDisplayAdBusinessName = "ad_group_ad.ad.legacy_responsive_display_ad.business_name";
        public static final String adLegacyResponsiveDisplayAdCallToActionText = "ad_group_ad.ad.legacy_responsive_display_ad.call_to_action_text";
        public static final String adLegacyResponsiveDisplayAdDescription = "ad_group_ad.ad.legacy_responsive_display_ad.description";
        public static final String adLegacyResponsiveDisplayAdFormatSetting = "ad_group_ad.ad.legacy_responsive_display_ad.format_setting";
        public static final String adLegacyResponsiveDisplayAdLogoImage = "ad_group_ad.ad.legacy_responsive_display_ad.logo_image";
        public static final String adLegacyResponsiveDisplayAdLongHeadline = "ad_group_ad.ad.legacy_responsive_display_ad.long_headline";
        public static final String adLegacyResponsiveDisplayAdMainColor = "ad_group_ad.ad.legacy_responsive_display_ad.main_color";
        public static final String adLegacyResponsiveDisplayAdMarketingImage = "ad_group_ad.ad.legacy_responsive_display_ad.marketing_image";
        public static final String adLegacyResponsiveDisplayAdPricePrefix = "ad_group_ad.ad.legacy_responsive_display_ad.price_prefix";
        public static final String adLegacyResponsiveDisplayAdPromoText = "ad_group_ad.ad.legacy_responsive_display_ad.promo_text";
        public static final String adLegacyResponsiveDisplayAdShortHeadline = "ad_group_ad.ad.legacy_responsive_display_ad.short_headline";
        public static final String adLegacyResponsiveDisplayAdSquareLogoImage = "ad_group_ad.ad.legacy_responsive_display_ad.square_logo_image";
        public static final String adLegacyResponsiveDisplayAdSquareMarketingImage = "ad_group_ad.ad.legacy_responsive_display_ad.square_marketing_image";
        public static final String adLocalAdCallToActions = "ad_group_ad.ad.local_ad.call_to_actions";
        public static final String adLocalAdDescriptions = "ad_group_ad.ad.local_ad.descriptions";
        public static final String adLocalAdHeadlines = "ad_group_ad.ad.local_ad.headlines";
        public static final String adLocalAdLogoImages = "ad_group_ad.ad.local_ad.logo_images";
        public static final String adLocalAdLogoImagesAsset = "ad_group_ad.ad.local_ad.logo_images.asset";
        public static final String adLocalAdMarketingImages = "ad_group_ad.ad.local_ad.marketing_images";
        public static final String adLocalAdMarketingImagesAsset = "ad_group_ad.ad.local_ad.marketing_images.asset";
        public static final String adLocalAdPath1 = "ad_group_ad.ad.local_ad.path1";
        public static final String adLocalAdPath2 = "ad_group_ad.ad.local_ad.path2";
        public static final String adLocalAdVideos = "ad_group_ad.ad.local_ad.videos";
        public static final String adLocalAdVideosAsset = "ad_group_ad.ad.local_ad.videos.asset";
        public static final String adName = "ad_group_ad.ad.name";
        public static final String adResourceName = "ad_group_ad.ad.resource_name";
        public static final String adResponsiveDisplayAdAccentColor = "ad_group_ad.ad.responsive_display_ad.accent_color";
        public static final String adResponsiveDisplayAdAllowFlexibleColor = "ad_group_ad.ad.responsive_display_ad.allow_flexible_color";
        public static final String adResponsiveDisplayAdBusinessName = "ad_group_ad.ad.responsive_display_ad.business_name";
        public static final String adResponsiveDisplayAdCallToActionText = "ad_group_ad.ad.responsive_display_ad.call_to_action_text";
        public static final String adResponsiveDisplayAdControlSpecEnableAssetEnhancements = "ad_group_ad.ad.responsive_display_ad.control_spec.enable_asset_enhancements";
        public static final String adResponsiveDisplayAdControlSpecEnableAutogenVideo = "ad_group_ad.ad.responsive_display_ad.control_spec.enable_autogen_video";
        public static final String adResponsiveDisplayAdDescriptions = "ad_group_ad.ad.responsive_display_ad.descriptions";
        public static final String adResponsiveDisplayAdFormatSetting = "ad_group_ad.ad.responsive_display_ad.format_setting";
        public static final String adResponsiveDisplayAdHeadlines = "ad_group_ad.ad.responsive_display_ad.headlines";
        public static final String adResponsiveDisplayAdLogoImages = "ad_group_ad.ad.responsive_display_ad.logo_images";
        public static final String adResponsiveDisplayAdLogoImagesAsset = "ad_group_ad.ad.responsive_display_ad.logo_images.asset";
        public static final String adResponsiveDisplayAdLongHeadline = "ad_group_ad.ad.responsive_display_ad.long_headline";
        public static final String adResponsiveDisplayAdMainColor = "ad_group_ad.ad.responsive_display_ad.main_color";
        public static final String adResponsiveDisplayAdMarketingImages = "ad_group_ad.ad.responsive_display_ad.marketing_images";
        public static final String adResponsiveDisplayAdMarketingImagesAsset = "ad_group_ad.ad.responsive_display_ad.marketing_images.asset";
        public static final String adResponsiveDisplayAdPricePrefix = "ad_group_ad.ad.responsive_display_ad.price_prefix";
        public static final String adResponsiveDisplayAdPromoText = "ad_group_ad.ad.responsive_display_ad.promo_text";
        public static final String adResponsiveDisplayAdSquareLogoImages = "ad_group_ad.ad.responsive_display_ad.square_logo_images";
        public static final String adResponsiveDisplayAdSquareLogoImagesAsset = "ad_group_ad.ad.responsive_display_ad.square_logo_images.asset";
        public static final String adResponsiveDisplayAdSquareMarketingImages = "ad_group_ad.ad.responsive_display_ad.square_marketing_images";
        public static final String adResponsiveDisplayAdSquareMarketingImagesAsset = "ad_group_ad.ad.responsive_display_ad.square_marketing_images.asset";
        public static final String adResponsiveDisplayAdYoutubeVideos = "ad_group_ad.ad.responsive_display_ad.youtube_videos";
        public static final String adResponsiveDisplayAdYoutubeVideosAsset = "ad_group_ad.ad.responsive_display_ad.youtube_videos.asset";
        public static final String adResponsiveSearchAdDescriptions = "ad_group_ad.ad.responsive_search_ad.descriptions";
        public static final String adResponsiveSearchAdHeadlines = "ad_group_ad.ad.responsive_search_ad.headlines";
        public static final String adResponsiveSearchAdPath1 = "ad_group_ad.ad.responsive_search_ad.path1";
        public static final String adResponsiveSearchAdPath2 = "ad_group_ad.ad.responsive_search_ad.path2";
        public static final String adShoppingComparisonListingAdHeadline = "ad_group_ad.ad.shopping_comparison_listing_ad.headline";
        public static final String adShoppingProductAd = "ad_group_ad.ad.shopping_product_ad";
        public static final String adShoppingSmartAd = "ad_group_ad.ad.shopping_smart_ad";
        public static final String adSmartCampaignAdDescriptions = "ad_group_ad.ad.smart_campaign_ad.descriptions";
        public static final String adSmartCampaignAdHeadlines = "ad_group_ad.ad.smart_campaign_ad.headlines";
        public static final String adSystemManagedResourceSource = "ad_group_ad.ad.system_managed_resource_source";
        public static final String adTextAdDescription1 = "ad_group_ad.ad.text_ad.description1";
        public static final String adTextAdDescription2 = "ad_group_ad.ad.text_ad.description2";
        public static final String adTextAdHeadline = "ad_group_ad.ad.text_ad.headline";
        public static final String adTrackingUrlTemplate = "ad_group_ad.ad.tracking_url_template";
        public static final String adTravelAd = "ad_group_ad.ad.travel_ad";
        public static final String adType = "ad_group_ad.ad.type";
        public static final String adUrlCollections = "ad_group_ad.ad.url_collections";
        public static final String adUrlCustomParameters = "ad_group_ad.ad.url_custom_parameters";
        public static final String adVideoAdBumperActionButtonLabel = "ad_group_ad.ad.video_ad.bumper.action_button_label";
        public static final String adVideoAdBumperActionHeadline = "ad_group_ad.ad.video_ad.bumper.action_headline";
        public static final String adVideoAdBumperCompanionBannerAsset = "ad_group_ad.ad.video_ad.bumper.companion_banner.asset";
        public static final String adVideoAdInFeedDescription1 = "ad_group_ad.ad.video_ad.in_feed.description1";
        public static final String adVideoAdInFeedDescription2 = "ad_group_ad.ad.video_ad.in_feed.description2";
        public static final String adVideoAdInFeedHeadline = "ad_group_ad.ad.video_ad.in_feed.headline";
        public static final String adVideoAdInFeedThumbnail = "ad_group_ad.ad.video_ad.in_feed.thumbnail";
        public static final String adVideoAdInStreamActionButtonLabel = "ad_group_ad.ad.video_ad.in_stream.action_button_label";
        public static final String adVideoAdInStreamActionHeadline = "ad_group_ad.ad.video_ad.in_stream.action_headline";
        public static final String adVideoAdInStreamCompanionBannerAsset = "ad_group_ad.ad.video_ad.in_stream.companion_banner.asset";
        public static final String adVideoAdNonSkippableActionButtonLabel = "ad_group_ad.ad.video_ad.non_skippable.action_button_label";
        public static final String adVideoAdNonSkippableActionHeadline = "ad_group_ad.ad.video_ad.non_skippable.action_headline";
        public static final String adVideoAdNonSkippableCompanionBannerAsset = "ad_group_ad.ad.video_ad.non_skippable.companion_banner.asset";
        public static final String adVideoAdOutStreamDescription = "ad_group_ad.ad.video_ad.out_stream.description";
        public static final String adVideoAdOutStreamHeadline = "ad_group_ad.ad.video_ad.out_stream.headline";
        public static final String adVideoAdVideoAsset = "ad_group_ad.ad.video_ad.video.asset";
        public static final String adVideoResponsiveAdBreadcrumb1 = "ad_group_ad.ad.video_responsive_ad.breadcrumb1";
        public static final String adVideoResponsiveAdBreadcrumb2 = "ad_group_ad.ad.video_responsive_ad.breadcrumb2";
        public static final String adVideoResponsiveAdCallToActions = "ad_group_ad.ad.video_responsive_ad.call_to_actions";
        public static final String adVideoResponsiveAdCompanionBanners = "ad_group_ad.ad.video_responsive_ad.companion_banners";
        public static final String adVideoResponsiveAdCompanionBannersAsset = "ad_group_ad.ad.video_responsive_ad.companion_banners.asset";
        public static final String adVideoResponsiveAdDescriptions = "ad_group_ad.ad.video_responsive_ad.descriptions";
        public static final String adVideoResponsiveAdHeadlines = "ad_group_ad.ad.video_responsive_ad.headlines";
        public static final String adVideoResponsiveAdLongHeadlines = "ad_group_ad.ad.video_responsive_ad.long_headlines";
        public static final String adVideoResponsiveAdVideos = "ad_group_ad.ad.video_responsive_ad.videos";
        public static final String adVideoResponsiveAdVideosAsset = "ad_group_ad.ad.video_responsive_ad.videos.asset";
        public static final String adGroup = "ad_group_ad.ad_group";
        public static final String adStrength = "ad_group_ad.ad_strength";
        public static final String labels = "ad_group_ad.labels";
        public static final String policySummaryApprovalStatus = "ad_group_ad.policy_summary.approval_status";
        public static final String policySummaryPolicyTopicEntries = "ad_group_ad.policy_summary.policy_topic_entries";
        public static final String policySummaryReviewStatus = "ad_group_ad.policy_summary.review_status";
        public static final String primaryStatus = "ad_group_ad.primary_status";
        public static final String primaryStatusReasons = "ad_group_ad.primary_status_reasons";
        public static final String resourceName = "ad_group_ad.resource_name";
        public static final String status = "ad_group_ad.status";
    }

    public static class AdGroupAdAssetCombinationView {
        public static final String enabled = "ad_group_ad_asset_combination_view.enabled";
        public static final String resourceName = "ad_group_ad_asset_combination_view.resource_name";
        public static final String servedAssets = "ad_group_ad_asset_combination_view.served_assets";
    }

    public static class AdGroupAdAssetView {
        public static final String adGroupAd = "ad_group_ad_asset_view.ad_group_ad";
        public static final String asset = "ad_group_ad_asset_view.asset";
        public static final String enabled = "ad_group_ad_asset_view.enabled";
        public static final String fieldType = "ad_group_ad_asset_view.field_type";
        public static final String performanceLabel = "ad_group_ad_asset_view.performance_label";
        public static final String pinnedField = "ad_group_ad_asset_view.pinned_field";
        public static final String policySummary = "ad_group_ad_asset_view.policy_summary";
        public static final String resourceName = "ad_group_ad_asset_view.resource_name";
        public static final String source = "ad_group_ad_asset_view.source";
    }

    public static class AdGroupAdLabel {
        public static final String adGroupAd = "ad_group_ad_label.ad_group_ad";
        public static final String label = "ad_group_ad_label.label";
        public static final String resourceName = "ad_group_ad_label.resource_name";
    }

    public static class AdGroupAsset {
        public static final String adGroup = "ad_group_asset.ad_group";
        public static final String asset = "ad_group_asset.asset";
        public static final String fieldType = "ad_group_asset.field_type";
        public static final String primaryStatus = "ad_group_asset.primary_status";
        public static final String primaryStatusDetails = "ad_group_asset.primary_status_details";
        public static final String primaryStatusReasons = "ad_group_asset.primary_status_reasons";
        public static final String resourceName = "ad_group_asset.resource_name";
        public static final String source = "ad_group_asset.source";
        public static final String status = "ad_group_asset.status";
    }

    public static class AdGroupAssetSet {
        public static final String adGroup = "ad_group_asset_set.ad_group";
        public static final String assetSet = "ad_group_asset_set.asset_set";
        public static final String resourceName = "ad_group_asset_set.resource_name";
        public static final String status = "ad_group_asset_set.status";
    }

    public static class AdGroupAudienceView {
        public static final String resourceName = "ad_group_audience_view.resource_name";
    }

    public static class AdGroupBidModifier {
        public static final String adGroup = "ad_group_bid_modifier.ad_group";
        public static final String baseAdGroup = "ad_group_bid_modifier.base_ad_group";
        public static final String bidModifier = "ad_group_bid_modifier.bid_modifier";
        public static final String bidModifierSource = "ad_group_bid_modifier.bid_modifier_source";
        public static final String criterionId = "ad_group_bid_modifier.criterion_id";
        public static final String deviceType = "ad_group_bid_modifier.device.type";
        public static final String hotelAdvanceBookingWindowMaxDays = "ad_group_bid_modifier.hotel_advance_booking_window.max_days";
        public static final String hotelAdvanceBookingWindowMinDays = "ad_group_bid_modifier.hotel_advance_booking_window.min_days";
        public static final String hotelCheckInDateRangeEndDate = "ad_group_bid_modifier.hotel_check_in_date_range.end_date";
        public static final String hotelCheckInDateRangeStartDate = "ad_group_bid_modifier.hotel_check_in_date_range.start_date";
        public static final String hotelCheckInDayDayOfWeek = "ad_group_bid_modifier.hotel_check_in_day.day_of_week";
        public static final String hotelDateSelectionTypeType = "ad_group_bid_modifier.hotel_date_selection_type.type";
        public static final String hotelLengthOfStayMaxNights = "ad_group_bid_modifier.hotel_length_of_stay.max_nights";
        public static final String hotelLengthOfStayMinNights = "ad_group_bid_modifier.hotel_length_of_stay.min_nights";
        public static final String resourceName = "ad_group_bid_modifier.resource_name";
    }

    public static class AdGroupCriterion {
        public static final String adGroup = "ad_group_criterion.ad_group";
        public static final String ageRangeType = "ad_group_criterion.age_range.type";
        public static final String appPaymentModelType = "ad_group_criterion.app_payment_model.type";
        public static final String approvalStatus = "ad_group_criterion.approval_status";
        public static final String audienceAudience = "ad_group_criterion.audience.audience";
        public static final String bidModifier = "ad_group_criterion.bid_modifier";
        public static final String combinedAudienceCombinedAudience = "ad_group_criterion.combined_audience.combined_audience";
        public static final String cpcBidMicros = "ad_group_criterion.cpc_bid_micros";
        public static final String cpmBidMicros = "ad_group_criterion.cpm_bid_micros";
        public static final String cpvBidMicros = "ad_group_criterion.cpv_bid_micros";
        public static final String criterionId = "ad_group_criterion.criterion_id";
        public static final String customAffinityCustomAffinity = "ad_group_criterion.custom_affinity.custom_affinity";
        public static final String customAudienceCustomAudience = "ad_group_criterion.custom_audience.custom_audience";
        public static final String customIntentCustomIntent = "ad_group_criterion.custom_intent.custom_intent";
        public static final String disapprovalReasons = "ad_group_criterion.disapproval_reasons";
        public static final String displayName = "ad_group_criterion.display_name";
        public static final String effectiveCpcBidMicros = "ad_group_criterion.effective_cpc_bid_micros";
        public static final String effectiveCpcBidSource = "ad_group_criterion.effective_cpc_bid_source";
        public static final String effectiveCpmBidMicros = "ad_group_criterion.effective_cpm_bid_micros";
        public static final String effectiveCpmBidSource = "ad_group_criterion.effective_cpm_bid_source";
        public static final String effectiveCpvBidMicros = "ad_group_criterion.effective_cpv_bid_micros";
        public static final String effectiveCpvBidSource = "ad_group_criterion.effective_cpv_bid_source";
        public static final String effectivePercentCpcBidMicros = "ad_group_criterion.effective_percent_cpc_bid_micros";
        public static final String effectivePercentCpcBidSource = "ad_group_criterion.effective_percent_cpc_bid_source";
        public static final String finalMobileUrls = "ad_group_criterion.final_mobile_urls";
        public static final String finalUrlSuffix = "ad_group_criterion.final_url_suffix";
        public static final String finalUrls = "ad_group_criterion.final_urls";
        public static final String genderType = "ad_group_criterion.gender.type";
        public static final String incomeRangeType = "ad_group_criterion.income_range.type";
        public static final String keywordMatchType = "ad_group_criterion.keyword.match_type";
        public static final String keywordText = "ad_group_criterion.keyword.text";
        public static final String labels = "ad_group_criterion.labels";
        public static final String languageLanguageConstant = "ad_group_criterion.language.language_constant";
        public static final String listingGroupCaseValueActivityCityValue = "ad_group_criterion.listing_group.case_value.activity_city.value";
        public static final String listingGroupCaseValueActivityCountryValue = "ad_group_criterion.listing_group.case_value.activity_country.value";
        public static final String listingGroupCaseValueActivityIdValue = "ad_group_criterion.listing_group.case_value.activity_id.value";
        public static final String listingGroupCaseValueActivityRatingValue = "ad_group_criterion.listing_group.case_value.activity_rating.value";
        public static final String listingGroupCaseValueActivityStateValue = "ad_group_criterion.listing_group.case_value.activity_state.value";
        public static final String listingGroupCaseValueHotelCityCityCriterion = "ad_group_criterion.listing_group.case_value.hotel_city.city_criterion";
        public static final String listingGroupCaseValueHotelClassValue = "ad_group_criterion.listing_group.case_value.hotel_class.value";
        public static final String listingGroupCaseValueHotelCountryRegionCountryRegionCriterion = "ad_group_criterion.listing_group.case_value.hotel_country_region.country_region_criterion";
        public static final String listingGroupCaseValueHotelIdValue = "ad_group_criterion.listing_group.case_value.hotel_id.value";
        public static final String listingGroupCaseValueHotelStateStateCriterion = "ad_group_criterion.listing_group.case_value.hotel_state.state_criterion";
        public static final String listingGroupCaseValueProductBrandValue = "ad_group_criterion.listing_group.case_value.product_brand.value";
        public static final String listingGroupCaseValueProductCategoryCategoryId = "ad_group_criterion.listing_group.case_value.product_category.category_id";
        public static final String listingGroupCaseValueProductCategoryLevel = "ad_group_criterion.listing_group.case_value.product_category.level";
        public static final String listingGroupCaseValueProductChannelChannel = "ad_group_criterion.listing_group.case_value.product_channel.channel";
        public static final String listingGroupCaseValueProductChannelExclusivityChannelExclusivity = "ad_group_criterion.listing_group.case_value.product_channel_exclusivity.channel_exclusivity";
        public static final String listingGroupCaseValueProductConditionCondition = "ad_group_criterion.listing_group.case_value.product_condition.condition";
        public static final String listingGroupCaseValueProductCustomAttributeIndex = "ad_group_criterion.listing_group.case_value.product_custom_attribute.index";
        public static final String listingGroupCaseValueProductCustomAttributeValue = "ad_group_criterion.listing_group.case_value.product_custom_attribute.value";
        public static final String listingGroupCaseValueProductItemIdValue = "ad_group_criterion.listing_group.case_value.product_item_id.value";
        public static final String listingGroupCaseValueProductTypeLevel = "ad_group_criterion.listing_group.case_value.product_type.level";
        public static final String listingGroupCaseValueProductTypeValue = "ad_group_criterion.listing_group.case_value.product_type.value";
        public static final String listingGroupParentAdGroupCriterion = "ad_group_criterion.listing_group.parent_ad_group_criterion";
        public static final String listingGroupPath = "ad_group_criterion.listing_group.path";
        public static final String listingGroupType = "ad_group_criterion.listing_group.type";
        public static final String locationGeoTargetConstant = "ad_group_criterion.location.geo_target_constant";
        public static final String mobileAppCategoryMobileAppCategoryConstant = "ad_group_criterion.mobile_app_category.mobile_app_category_constant";
        public static final String mobileApplicationAppId = "ad_group_criterion.mobile_application.app_id";
        public static final String mobileApplicationName = "ad_group_criterion.mobile_application.name";
        public static final String negative = "ad_group_criterion.negative";
        public static final String parentalStatusType = "ad_group_criterion.parental_status.type";
        public static final String percentCpcBidMicros = "ad_group_criterion.percent_cpc_bid_micros";
        public static final String placementUrl = "ad_group_criterion.placement.url";
        public static final String positionEstimatesEstimatedAddClicksAtFirstPositionCpc = "ad_group_criterion.position_estimates.estimated_add_clicks_at_first_position_cpc";
        public static final String positionEstimatesEstimatedAddCostAtFirstPositionCpc = "ad_group_criterion.position_estimates.estimated_add_cost_at_first_position_cpc";
        public static final String positionEstimatesFirstPageCpcMicros = "ad_group_criterion.position_estimates.first_page_cpc_micros";
        public static final String positionEstimatesFirstPositionCpcMicros = "ad_group_criterion.position_estimates.first_position_cpc_micros";
        public static final String positionEstimatesTopOfPageCpcMicros = "ad_group_criterion.position_estimates.top_of_page_cpc_micros";
        public static final String qualityInfoCreativeQualityScore = "ad_group_criterion.quality_info.creative_quality_score";
        public static final String qualityInfoPostClickQualityScore = "ad_group_criterion.quality_info.post_click_quality_score";
        public static final String qualityInfoQualityScore = "ad_group_criterion.quality_info.quality_score";
        public static final String qualityInfoSearchPredictedCtr = "ad_group_criterion.quality_info.search_predicted_ctr";
        public static final String resourceName = "ad_group_criterion.resource_name";
        public static final String status = "ad_group_criterion.status";
        public static final String systemServingStatus = "ad_group_criterion.system_serving_status";
        public static final String topicPath = "ad_group_criterion.topic.path";
        public static final String topicTopicConstant = "ad_group_criterion.topic.topic_constant";
        public static final String trackingUrlTemplate = "ad_group_criterion.tracking_url_template";
        public static final String type = "ad_group_criterion.type";
        public static final String urlCustomParameters = "ad_group_criterion.url_custom_parameters";
        public static final String userInterestUserInterestCategory = "ad_group_criterion.user_interest.user_interest_category";
        public static final String userListUserList = "ad_group_criterion.user_list.user_list";
        public static final String webpageConditions = "ad_group_criterion.webpage.conditions";
        public static final String webpageCoveragePercentage = "ad_group_criterion.webpage.coverage_percentage";
        public static final String webpageCriterionName = "ad_group_criterion.webpage.criterion_name";
        public static final String webpageSampleSampleUrls = "ad_group_criterion.webpage.sample.sample_urls";
        public static final String youtubeChannelChannelId = "ad_group_criterion.youtube_channel.channel_id";
        public static final String youtubeVideoVideoId = "ad_group_criterion.youtube_video.video_id";
    }

    public static class AdGroupCriterionCustomizer {
        public static final String adGroupCriterion = "ad_group_criterion_customizer.ad_group_criterion";
        public static final String customizerAttribute = "ad_group_criterion_customizer.customizer_attribute";
        public static final String resourceName = "ad_group_criterion_customizer.resource_name";
        public static final String status = "ad_group_criterion_customizer.status";
        public static final String valueStringValue = "ad_group_criterion_customizer.value.string_value";
        public static final String valueType = "ad_group_criterion_customizer.value.type";
    }

    public static class AdGroupCriterionLabel {
        public static final String adGroupCriterion = "ad_group_criterion_label.ad_group_criterion";
        public static final String label = "ad_group_criterion_label.label";
        public static final String resourceName = "ad_group_criterion_label.resource_name";
    }

    public static class AdGroupCriterionSimulation {
        public static final String adGroupId = "ad_group_criterion_simulation.ad_group_id";
        public static final String cpcBidPointListPoints = "ad_group_criterion_simulation.cpc_bid_point_list.points";
        public static final String criterionId = "ad_group_criterion_simulation.criterion_id";
        public static final String endDate = "ad_group_criterion_simulation.end_date";
        public static final String modificationMethod = "ad_group_criterion_simulation.modification_method";
        public static final String percentCpcBidPointListPoints = "ad_group_criterion_simulation.percent_cpc_bid_point_list.points";
        public static final String resourceName = "ad_group_criterion_simulation.resource_name";
        public static final String startDate = "ad_group_criterion_simulation.start_date";
        public static final String type = "ad_group_criterion_simulation.type";
    }

    public static class AdGroupCustomizer {
        public static final String adGroup = "ad_group_customizer.ad_group";
        public static final String customizerAttribute = "ad_group_customizer.customizer_attribute";
        public static final String resourceName = "ad_group_customizer.resource_name";
        public static final String status = "ad_group_customizer.status";
        public static final String valueStringValue = "ad_group_customizer.value.string_value";
        public static final String valueType = "ad_group_customizer.value.type";
    }

    public static class AdGroupExtensionSetting {
        public static final String adGroup = "ad_group_extension_setting.ad_group";
        public static final String device = "ad_group_extension_setting.device";
        public static final String extensionFeedItems = "ad_group_extension_setting.extension_feed_items";
        public static final String extensionType = "ad_group_extension_setting.extension_type";
        public static final String resourceName = "ad_group_extension_setting.resource_name";
    }

    public static class AdGroupFeed {
        public static final String adGroup = "ad_group_feed.ad_group";
        public static final String feed = "ad_group_feed.feed";
        public static final String matchingFunctionFunctionString = "ad_group_feed.matching_function.function_string";
        public static final String matchingFunctionLeftOperands = "ad_group_feed.matching_function.left_operands";
        public static final String matchingFunctionOperator = "ad_group_feed.matching_function.operator";
        public static final String matchingFunctionRightOperands = "ad_group_feed.matching_function.right_operands";
        public static final String placeholderTypes = "ad_group_feed.placeholder_types";
        public static final String resourceName = "ad_group_feed.resource_name";
        public static final String status = "ad_group_feed.status";
    }

    public static class AdGroupLabel {
        public static final String adGroup = "ad_group_label.ad_group";
        public static final String label = "ad_group_label.label";
        public static final String resourceName = "ad_group_label.resource_name";
    }

    public static class AdGroupSimulation {
        public static final String adGroupId = "ad_group_simulation.ad_group_id";
        public static final String cpcBidPointListPoints = "ad_group_simulation.cpc_bid_point_list.points";
        public static final String cpvBidPointListPoints = "ad_group_simulation.cpv_bid_point_list.points";
        public static final String endDate = "ad_group_simulation.end_date";
        public static final String modificationMethod = "ad_group_simulation.modification_method";
        public static final String resourceName = "ad_group_simulation.resource_name";
        public static final String startDate = "ad_group_simulation.start_date";
        public static final String targetCpaPointListPoints = "ad_group_simulation.target_cpa_point_list.points";
        public static final String targetRoasPointListPoints = "ad_group_simulation.target_roas_point_list.points";
        public static final String type = "ad_group_simulation.type";
    }

    public static class AdParameter {
        public static final String adGroupCriterion = "ad_parameter.ad_group_criterion";
        public static final String insertionText = "ad_parameter.insertion_text";
        public static final String parameterIndex = "ad_parameter.parameter_index";
        public static final String resourceName = "ad_parameter.resource_name";
    }

    public static class AdScheduleView {
        public static final String resourceName = "ad_schedule_view.resource_name";
    }

    public static class AgeRangeView {
        public static final String resourceName = "age_range_view.resource_name";
    }

    public static class AndroidPrivacySharedKeyGoogleAdGroup {
        public static final String adGroupId = "android_privacy_shared_key_google_ad_group.ad_group_id";
        public static final String androidPrivacyInteractionDate = "android_privacy_shared_key_google_ad_group.android_privacy_interaction_date";
        public static final String androidPrivacyInteractionType = "android_privacy_shared_key_google_ad_group.android_privacy_interaction_type";
        public static final String androidPrivacyNetworkType = "android_privacy_shared_key_google_ad_group.android_privacy_network_type";
        public static final String campaignId = "android_privacy_shared_key_google_ad_group.campaign_id";
        public static final String resourceName = "android_privacy_shared_key_google_ad_group.resource_name";
        public static final String sharedAdGroupKey = "android_privacy_shared_key_google_ad_group.shared_ad_group_key";
    }

    public static class AndroidPrivacySharedKeyGoogleCampaign {
        public static final String androidPrivacyInteractionDate = "android_privacy_shared_key_google_campaign.android_privacy_interaction_date";
        public static final String androidPrivacyInteractionType = "android_privacy_shared_key_google_campaign.android_privacy_interaction_type";
        public static final String campaignId = "android_privacy_shared_key_google_campaign.campaign_id";
        public static final String resourceName = "android_privacy_shared_key_google_campaign.resource_name";
        public static final String sharedCampaignKey = "android_privacy_shared_key_google_campaign.shared_campaign_key";
    }

    public static class AndroidPrivacySharedKeyGoogleNetworkType {
        public static final String androidPrivacyInteractionDate = "android_privacy_shared_key_google_network_type.android_privacy_interaction_date";
        public static final String androidPrivacyInteractionType = "android_privacy_shared_key_google_network_type.android_privacy_interaction_type";
        public static final String androidPrivacyNetworkType = "android_privacy_shared_key_google_network_type.android_privacy_network_type";
        public static final String campaignId = "android_privacy_shared_key_google_network_type.campaign_id";
        public static final String resourceName = "android_privacy_shared_key_google_network_type.resource_name";
        public static final String sharedNetworkTypeKey = "android_privacy_shared_key_google_network_type.shared_network_type_key";
    }

    public static class Asset {
        public static final String bookOnGoogleAsset = "asset.book_on_google_asset";
        public static final String callAssetAdScheduleTargets = "asset.call_asset.ad_schedule_targets";
        public static final String callAssetCallConversionAction = "asset.call_asset.call_conversion_action";
        public static final String callAssetCallConversionReportingState = "asset.call_asset.call_conversion_reporting_state";
        public static final String callAssetCountryCode = "asset.call_asset.country_code";
        public static final String callAssetPhoneNumber = "asset.call_asset.phone_number";
        public static final String callToActionAssetCallToAction = "asset.call_to_action_asset.call_to_action";
        public static final String calloutAssetAdScheduleTargets = "asset.callout_asset.ad_schedule_targets";
        public static final String calloutAssetCalloutText = "asset.callout_asset.callout_text";
        public static final String calloutAssetEndDate = "asset.callout_asset.end_date";
        public static final String calloutAssetStartDate = "asset.callout_asset.start_date";
        public static final String discoveryCarouselCardAssetCallToActionText = "asset.discovery_carousel_card_asset.call_to_action_text";
        public static final String discoveryCarouselCardAssetHeadline = "asset.discovery_carousel_card_asset.headline";
        public static final String discoveryCarouselCardAssetMarketingImageAsset = "asset.discovery_carousel_card_asset.marketing_image_asset";
        public static final String discoveryCarouselCardAssetPortraitMarketingImageAsset = "asset.discovery_carousel_card_asset.portrait_marketing_image_asset";
        public static final String discoveryCarouselCardAssetSquareMarketingImageAsset = "asset.discovery_carousel_card_asset.square_marketing_image_asset";
        public static final String dynamicCustomAssetAndroidAppLink = "asset.dynamic_custom_asset.android_app_link";
        public static final String dynamicCustomAssetContextualKeywords = "asset.dynamic_custom_asset.contextual_keywords";
        public static final String dynamicCustomAssetFormattedPrice = "asset.dynamic_custom_asset.formatted_price";
        public static final String dynamicCustomAssetFormattedSalePrice = "asset.dynamic_custom_asset.formatted_sale_price";
        public static final String dynamicCustomAssetId = "asset.dynamic_custom_asset.id";
        public static final String dynamicCustomAssetId2 = "asset.dynamic_custom_asset.id2";
        public static final String dynamicCustomAssetImageUrl = "asset.dynamic_custom_asset.image_url";
        public static final String dynamicCustomAssetIosAppLink = "asset.dynamic_custom_asset.ios_app_link";
        public static final String dynamicCustomAssetIosAppStoreId = "asset.dynamic_custom_asset.ios_app_store_id";
        public static final String dynamicCustomAssetItemAddress = "asset.dynamic_custom_asset.item_address";
        public static final String dynamicCustomAssetItemCategory = "asset.dynamic_custom_asset.item_category";
        public static final String dynamicCustomAssetItemDescription = "asset.dynamic_custom_asset.item_description";
        public static final String dynamicCustomAssetItemSubtitle = "asset.dynamic_custom_asset.item_subtitle";
        public static final String dynamicCustomAssetItemTitle = "asset.dynamic_custom_asset.item_title";
        public static final String dynamicCustomAssetPrice = "asset.dynamic_custom_asset.price";
        public static final String dynamicCustomAssetSalePrice = "asset.dynamic_custom_asset.sale_price";
        public static final String dynamicCustomAssetSimilarIds = "asset.dynamic_custom_asset.similar_ids";
        public static final String dynamicEducationAssetAddress = "asset.dynamic_education_asset.address";
        public static final String dynamicEducationAssetAndroidAppLink = "asset.dynamic_education_asset.android_app_link";
        public static final String dynamicEducationAssetContextualKeywords = "asset.dynamic_education_asset.contextual_keywords";
        public static final String dynamicEducationAssetImageUrl = "asset.dynamic_education_asset.image_url";
        public static final String dynamicEducationAssetIosAppLink = "asset.dynamic_education_asset.ios_app_link";
        public static final String dynamicEducationAssetIosAppStoreId = "asset.dynamic_education_asset.ios_app_store_id";
        public static final String dynamicEducationAssetLocationId = "asset.dynamic_education_asset.location_id";
        public static final String dynamicEducationAssetProgramDescription = "asset.dynamic_education_asset.program_description";
        public static final String dynamicEducationAssetProgramId = "asset.dynamic_education_asset.program_id";
        public static final String dynamicEducationAssetProgramName = "asset.dynamic_education_asset.program_name";
        public static final String dynamicEducationAssetSchoolName = "asset.dynamic_education_asset.school_name";
        public static final String dynamicEducationAssetSimilarProgramIds = "asset.dynamic_education_asset.similar_program_ids";
        public static final String dynamicEducationAssetSubject = "asset.dynamic_education_asset.subject";
        public static final String dynamicEducationAssetThumbnailImageUrl = "asset.dynamic_education_asset.thumbnail_image_url";
        public static final String dynamicFlightsAssetAndroidAppLink = "asset.dynamic_flights_asset.android_app_link";
        public static final String dynamicFlightsAssetCustomMapping = "asset.dynamic_flights_asset.custom_mapping";
        public static final String dynamicFlightsAssetDestinationId = "asset.dynamic_flights_asset.destination_id";
        public static final String dynamicFlightsAssetDestinationName = "asset.dynamic_flights_asset.destination_name";
        public static final String dynamicFlightsAssetFlightDescription = "asset.dynamic_flights_asset.flight_description";
        public static final String dynamicFlightsAssetFlightPrice = "asset.dynamic_flights_asset.flight_price";
        public static final String dynamicFlightsAssetFlightSalePrice = "asset.dynamic_flights_asset.flight_sale_price";
        public static final String dynamicFlightsAssetFormattedPrice = "asset.dynamic_flights_asset.formatted_price";
        public static final String dynamicFlightsAssetFormattedSalePrice = "asset.dynamic_flights_asset.formatted_sale_price";
        public static final String dynamicFlightsAssetImageUrl = "asset.dynamic_flights_asset.image_url";
        public static final String dynamicFlightsAssetIosAppLink = "asset.dynamic_flights_asset.ios_app_link";
        public static final String dynamicFlightsAssetIosAppStoreId = "asset.dynamic_flights_asset.ios_app_store_id";
        public static final String dynamicFlightsAssetOriginId = "asset.dynamic_flights_asset.origin_id";
        public static final String dynamicFlightsAssetOriginName = "asset.dynamic_flights_asset.origin_name";
        public static final String dynamicFlightsAssetSimilarDestinationIds = "asset.dynamic_flights_asset.similar_destination_ids";
        public static final String dynamicHotelsAndRentalsAssetAddress = "asset.dynamic_hotels_and_rentals_asset.address";
        public static final String dynamicHotelsAndRentalsAssetAndroidAppLink = "asset.dynamic_hotels_and_rentals_asset.android_app_link";
        public static final String dynamicHotelsAndRentalsAssetCategory = "asset.dynamic_hotels_and_rentals_asset.category";
        public static final String dynamicHotelsAndRentalsAssetContextualKeywords = "asset.dynamic_hotels_and_rentals_asset.contextual_keywords";
        public static final String dynamicHotelsAndRentalsAssetDescription = "asset.dynamic_hotels_and_rentals_asset.description";
        public static final String dynamicHotelsAndRentalsAssetDestinationName = "asset.dynamic_hotels_and_rentals_asset.destination_name";
        public static final String dynamicHotelsAndRentalsAssetFormattedPrice = "asset.dynamic_hotels_and_rentals_asset.formatted_price";
        public static final String dynamicHotelsAndRentalsAssetFormattedSalePrice = "asset.dynamic_hotels_and_rentals_asset.formatted_sale_price";
        public static final String dynamicHotelsAndRentalsAssetImageUrl = "asset.dynamic_hotels_and_rentals_asset.image_url";
        public static final String dynamicHotelsAndRentalsAssetIosAppLink = "asset.dynamic_hotels_and_rentals_asset.ios_app_link";
        public static final String dynamicHotelsAndRentalsAssetIosAppStoreId = "asset.dynamic_hotels_and_rentals_asset.ios_app_store_id";
        public static final String dynamicHotelsAndRentalsAssetPrice = "asset.dynamic_hotels_and_rentals_asset.price";
        public static final String dynamicHotelsAndRentalsAssetPropertyId = "asset.dynamic_hotels_and_rentals_asset.property_id";
        public static final String dynamicHotelsAndRentalsAssetPropertyName = "asset.dynamic_hotels_and_rentals_asset.property_name";
        public static final String dynamicHotelsAndRentalsAssetSalePrice = "asset.dynamic_hotels_and_rentals_asset.sale_price";
        public static final String dynamicHotelsAndRentalsAssetSimilarPropertyIds = "asset.dynamic_hotels_and_rentals_asset.similar_property_ids";
        public static final String dynamicHotelsAndRentalsAssetStarRating = "asset.dynamic_hotels_and_rentals_asset.star_rating";
        public static final String dynamicJobsAssetAddress = "asset.dynamic_jobs_asset.address";
        public static final String dynamicJobsAssetAndroidAppLink = "asset.dynamic_jobs_asset.android_app_link";
        public static final String dynamicJobsAssetContextualKeywords = "asset.dynamic_jobs_asset.contextual_keywords";
        public static final String dynamicJobsAssetDescription = "asset.dynamic_jobs_asset.description";
        public static final String dynamicJobsAssetImageUrl = "asset.dynamic_jobs_asset.image_url";
        public static final String dynamicJobsAssetIosAppLink = "asset.dynamic_jobs_asset.ios_app_link";
        public static final String dynamicJobsAssetIosAppStoreId = "asset.dynamic_jobs_asset.ios_app_store_id";
        public static final String dynamicJobsAssetJobCategory = "asset.dynamic_jobs_asset.job_category";
        public static final String dynamicJobsAssetJobId = "asset.dynamic_jobs_asset.job_id";
        public static final String dynamicJobsAssetJobSubtitle = "asset.dynamic_jobs_asset.job_subtitle";
        public static final String dynamicJobsAssetJobTitle = "asset.dynamic_jobs_asset.job_title";
        public static final String dynamicJobsAssetLocationId = "asset.dynamic_jobs_asset.location_id";
        public static final String dynamicJobsAssetSalary = "asset.dynamic_jobs_asset.salary";
        public static final String dynamicJobsAssetSimilarJobIds = "asset.dynamic_jobs_asset.similar_job_ids";
        public static final String dynamicLocalAssetAddress = "asset.dynamic_local_asset.address";
        public static final String dynamicLocalAssetAndroidAppLink = "asset.dynamic_local_asset.android_app_link";
        public static final String dynamicLocalAssetCategory = "asset.dynamic_local_asset.category";
        public static final String dynamicLocalAssetContextualKeywords = "asset.dynamic_local_asset.contextual_keywords";
        public static final String dynamicLocalAssetDealId = "asset.dynamic_local_asset.deal_id";
        public static final String dynamicLocalAssetDealName = "asset.dynamic_local_asset.deal_name";
        public static final String dynamicLocalAssetDescription = "asset.dynamic_local_asset.description";
        public static final String dynamicLocalAssetFormattedPrice = "asset.dynamic_local_asset.formatted_price";
        public static final String dynamicLocalAssetFormattedSalePrice = "asset.dynamic_local_asset.formatted_sale_price";
        public static final String dynamicLocalAssetImageUrl = "asset.dynamic_local_asset.image_url";
        public static final String dynamicLocalAssetIosAppLink = "asset.dynamic_local_asset.ios_app_link";
        public static final String dynamicLocalAssetIosAppStoreId = "asset.dynamic_local_asset.ios_app_store_id";
        public static final String dynamicLocalAssetPrice = "asset.dynamic_local_asset.price";
        public static final String dynamicLocalAssetSalePrice = "asset.dynamic_local_asset.sale_price";
        public static final String dynamicLocalAssetSimilarDealIds = "asset.dynamic_local_asset.similar_deal_ids";
        public static final String dynamicLocalAssetSubtitle = "asset.dynamic_local_asset.subtitle";
        public static final String dynamicRealEstateAssetAddress = "asset.dynamic_real_estate_asset.address";
        public static final String dynamicRealEstateAssetAndroidAppLink = "asset.dynamic_real_estate_asset.android_app_link";
        public static final String dynamicRealEstateAssetCityName = "asset.dynamic_real_estate_asset.city_name";
        public static final String dynamicRealEstateAssetContextualKeywords = "asset.dynamic_real_estate_asset.contextual_keywords";
        public static final String dynamicRealEstateAssetDescription = "asset.dynamic_real_estate_asset.description";
        public static final String dynamicRealEstateAssetFormattedPrice = "asset.dynamic_real_estate_asset.formatted_price";
        public static final String dynamicRealEstateAssetImageUrl = "asset.dynamic_real_estate_asset.image_url";
        public static final String dynamicRealEstateAssetIosAppLink = "asset.dynamic_real_estate_asset.ios_app_link";
        public static final String dynamicRealEstateAssetIosAppStoreId = "asset.dynamic_real_estate_asset.ios_app_store_id";
        public static final String dynamicRealEstateAssetListingId = "asset.dynamic_real_estate_asset.listing_id";
        public static final String dynamicRealEstateAssetListingName = "asset.dynamic_real_estate_asset.listing_name";
        public static final String dynamicRealEstateAssetListingType = "asset.dynamic_real_estate_asset.listing_type";
        public static final String dynamicRealEstateAssetPrice = "asset.dynamic_real_estate_asset.price";
        public static final String dynamicRealEstateAssetPropertyType = "asset.dynamic_real_estate_asset.property_type";
        public static final String dynamicRealEstateAssetSimilarListingIds = "asset.dynamic_real_estate_asset.similar_listing_ids";
        public static final String dynamicTravelAssetAndroidAppLink = "asset.dynamic_travel_asset.android_app_link";
        public static final String dynamicTravelAssetCategory = "asset.dynamic_travel_asset.category";
        public static final String dynamicTravelAssetContextualKeywords = "asset.dynamic_travel_asset.contextual_keywords";
        public static final String dynamicTravelAssetDestinationAddress = "asset.dynamic_travel_asset.destination_address";
        public static final String dynamicTravelAssetDestinationId = "asset.dynamic_travel_asset.destination_id";
        public static final String dynamicTravelAssetDestinationName = "asset.dynamic_travel_asset.destination_name";
        public static final String dynamicTravelAssetFormattedPrice = "asset.dynamic_travel_asset.formatted_price";
        public static final String dynamicTravelAssetFormattedSalePrice = "asset.dynamic_travel_asset.formatted_sale_price";
        public static final String dynamicTravelAssetImageUrl = "asset.dynamic_travel_asset.image_url";
        public static final String dynamicTravelAssetIosAppLink = "asset.dynamic_travel_asset.ios_app_link";
        public static final String dynamicTravelAssetIosAppStoreId = "asset.dynamic_travel_asset.ios_app_store_id";
        public static final String dynamicTravelAssetOriginId = "asset.dynamic_travel_asset.origin_id";
        public static final String dynamicTravelAssetOriginName = "asset.dynamic_travel_asset.origin_name";
        public static final String dynamicTravelAssetPrice = "asset.dynamic_travel_asset.price";
        public static final String dynamicTravelAssetSalePrice = "asset.dynamic_travel_asset.sale_price";
        public static final String dynamicTravelAssetSimilarDestinationIds = "asset.dynamic_travel_asset.similar_destination_ids";
        public static final String dynamicTravelAssetTitle = "asset.dynamic_travel_asset.title";
        public static final String fieldTypePolicySummaries = "asset.field_type_policy_summaries";
        public static final String finalMobileUrls = "asset.final_mobile_urls";
        public static final String finalUrlSuffix = "asset.final_url_suffix";
        public static final String finalUrls = "asset.final_urls";
        public static final String hotelCalloutAssetLanguageCode = "asset.hotel_callout_asset.language_code";
        public static final String hotelCalloutAssetText = "asset.hotel_callout_asset.text";
        public static final String hotelPropertyAssetHotelAddress = "asset.hotel_property_asset.hotel_address";
        public static final String hotelPropertyAssetHotelName = "asset.hotel_property_asset.hotel_name";
        public static final String hotelPropertyAssetPlaceId = "asset.hotel_property_asset.place_id";
        public static final String id = "asset.id";
        public static final String imageAssetFileSize = "asset.image_asset.file_size";
        public static final String imageAssetFullSizeHeightPixels = "asset.image_asset.full_size.height_pixels";
        public static final String imageAssetFullSizeUrl = "asset.image_asset.full_size.url";
        public static final String imageAssetFullSizeWidthPixels = "asset.image_asset.full_size.width_pixels";
        public static final String imageAssetMimeType = "asset.image_asset.mime_type";
        public static final String leadFormAssetBackgroundImageAsset = "asset.lead_form_asset.background_image_asset";
        public static final String leadFormAssetBusinessName = "asset.lead_form_asset.business_name";
        public static final String leadFormAssetCallToActionDescription = "asset.lead_form_asset.call_to_action_description";
        public static final String leadFormAssetCallToActionType = "asset.lead_form_asset.call_to_action_type";
        public static final String leadFormAssetCustomDisclosure = "asset.lead_form_asset.custom_disclosure";
        public static final String leadFormAssetCustomQuestionFields = "asset.lead_form_asset.custom_question_fields";
        public static final String leadFormAssetDeliveryMethods = "asset.lead_form_asset.delivery_methods";
        public static final String leadFormAssetDescription = "asset.lead_form_asset.description";
        public static final String leadFormAssetDesiredIntent = "asset.lead_form_asset.desired_intent";
        public static final String leadFormAssetFields = "asset.lead_form_asset.fields";
        public static final String leadFormAssetHeadline = "asset.lead_form_asset.headline";
        public static final String leadFormAssetPostSubmitCallToActionType = "asset.lead_form_asset.post_submit_call_to_action_type";
        public static final String leadFormAssetPostSubmitDescription = "asset.lead_form_asset.post_submit_description";
        public static final String leadFormAssetPostSubmitHeadline = "asset.lead_form_asset.post_submit_headline";
        public static final String leadFormAssetPrivacyPolicyUrl = "asset.lead_form_asset.privacy_policy_url";
        public static final String locationAssetBusinessProfileLocations = "asset.location_asset.business_profile_locations";
        public static final String locationAssetLocationOwnershipType = "asset.location_asset.location_ownership_type";
        public static final String locationAssetPlaceId = "asset.location_asset.place_id";
        public static final String mobileAppAssetAppId = "asset.mobile_app_asset.app_id";
        public static final String mobileAppAssetAppStore = "asset.mobile_app_asset.app_store";
        public static final String mobileAppAssetEndDate = "asset.mobile_app_asset.end_date";
        public static final String mobileAppAssetLinkText = "asset.mobile_app_asset.link_text";
        public static final String mobileAppAssetStartDate = "asset.mobile_app_asset.start_date";
        public static final String name = "asset.name";
        public static final String pageFeedAssetLabels = "asset.page_feed_asset.labels";
        public static final String pageFeedAssetPageUrl = "asset.page_feed_asset.page_url";
        public static final String policySummaryApprovalStatus = "asset.policy_summary.approval_status";
        public static final String policySummaryPolicyTopicEntries = "asset.policy_summary.policy_topic_entries";
        public static final String policySummaryReviewStatus = "asset.policy_summary.review_status";
        public static final String priceAssetLanguageCode = "asset.price_asset.language_code";
        public static final String priceAssetPriceOfferings = "asset.price_asset.price_offerings";
        public static final String priceAssetPriceQualifier = "asset.price_asset.price_qualifier";
        public static final String priceAssetType = "asset.price_asset.type";
        public static final String promotionAssetAdScheduleTargets = "asset.promotion_asset.ad_schedule_targets";
        public static final String promotionAssetDiscountModifier = "asset.promotion_asset.discount_modifier";
        public static final String promotionAssetEndDate = "asset.promotion_asset.end_date";
        public static final String promotionAssetLanguageCode = "asset.promotion_asset.language_code";
        public static final String promotionAssetMoneyAmountOffAmountMicros = "asset.promotion_asset.money_amount_off.amount_micros";
        public static final String promotionAssetMoneyAmountOffCurrencyCode = "asset.promotion_asset.money_amount_off.currency_code";
        public static final String promotionAssetOccasion = "asset.promotion_asset.occasion";
        public static final String promotionAssetOrdersOverAmountAmountMicros = "asset.promotion_asset.orders_over_amount.amount_micros";
        public static final String promotionAssetOrdersOverAmountCurrencyCode = "asset.promotion_asset.orders_over_amount.currency_code";
        public static final String promotionAssetPercentOff = "asset.promotion_asset.percent_off";
        public static final String promotionAssetPromotionCode = "asset.promotion_asset.promotion_code";
        public static final String promotionAssetPromotionTarget = "asset.promotion_asset.promotion_target";
        public static final String promotionAssetRedemptionEndDate = "asset.promotion_asset.redemption_end_date";
        public static final String promotionAssetRedemptionStartDate = "asset.promotion_asset.redemption_start_date";
        public static final String promotionAssetStartDate = "asset.promotion_asset.start_date";
        public static final String resourceName = "asset.resource_name";
        public static final String sitelinkAssetAdScheduleTargets = "asset.sitelink_asset.ad_schedule_targets";
        public static final String sitelinkAssetDescription1 = "asset.sitelink_asset.description1";
        public static final String sitelinkAssetDescription2 = "asset.sitelink_asset.description2";
        public static final String sitelinkAssetEndDate = "asset.sitelink_asset.end_date";
        public static final String sitelinkAssetLinkText = "asset.sitelink_asset.link_text";
        public static final String sitelinkAssetStartDate = "asset.sitelink_asset.start_date";
        public static final String source = "asset.source";
        public static final String structuredSnippetAssetHeader = "asset.structured_snippet_asset.header";
        public static final String structuredSnippetAssetValues = "asset.structured_snippet_asset.values";
        public static final String textAssetText = "asset.text_asset.text";
        public static final String trackingUrlTemplate = "asset.tracking_url_template";
        public static final String type = "asset.type";
        public static final String urlCustomParameters = "asset.url_custom_parameters";
        public static final String youtubeVideoAssetYoutubeVideoId = "asset.youtube_video_asset.youtube_video_id";
        public static final String youtubeVideoAssetYoutubeVideoTitle = "asset.youtube_video_asset.youtube_video_title";
    }

    public static class AssetFieldTypeView {
        public static final String fieldType = "asset_field_type_view.field_type";
        public static final String resourceName = "asset_field_type_view.resource_name";
    }

    public static class AssetGroup {
        public static final String adStrength = "asset_group.ad_strength";
        public static final String campaign = "asset_group.campaign";
        public static final String finalMobileUrls = "asset_group.final_mobile_urls";
        public static final String finalUrls = "asset_group.final_urls";
        public static final String id = "asset_group.id";
        public static final String name = "asset_group.name";
        public static final String path1 = "asset_group.path1";
        public static final String path2 = "asset_group.path2";
        public static final String primaryStatus = "asset_group.primary_status";
        public static final String primaryStatusReasons = "asset_group.primary_status_reasons";
        public static final String resourceName = "asset_group.resource_name";
        public static final String status = "asset_group.status";
    }

    public static class AssetGroupAsset {
        public static final String asset = "asset_group_asset.asset";
        public static final String assetGroup = "asset_group_asset.asset_group";
        public static final String fieldType = "asset_group_asset.field_type";
        public static final String performanceLabel = "asset_group_asset.performance_label";
        public static final String policySummaryApprovalStatus = "asset_group_asset.policy_summary.approval_status";
        public static final String policySummaryPolicyTopicEntries = "asset_group_asset.policy_summary.policy_topic_entries";
        public static final String policySummaryReviewStatus = "asset_group_asset.policy_summary.review_status";
        public static final String primaryStatus = "asset_group_asset.primary_status";
        public static final String primaryStatusDetails = "asset_group_asset.primary_status_details";
        public static final String primaryStatusReasons = "asset_group_asset.primary_status_reasons";
        public static final String resourceName = "asset_group_asset.resource_name";
        public static final String source = "asset_group_asset.source";
        public static final String status = "asset_group_asset.status";
    }

    public static class AssetGroupListingGroupFilter {
        public static final String assetGroup = "asset_group_listing_group_filter.asset_group";
        public static final String caseValueProductBrandValue = "asset_group_listing_group_filter.case_value.product_brand.value";
        public static final String caseValueProductCategoryCategoryId = "asset_group_listing_group_filter.case_value.product_category.category_id";
        public static final String caseValueProductCategoryLevel = "asset_group_listing_group_filter.case_value.product_category.level";
        public static final String caseValueProductChannelChannel = "asset_group_listing_group_filter.case_value.product_channel.channel";
        public static final String caseValueProductConditionCondition = "asset_group_listing_group_filter.case_value.product_condition.condition";
        public static final String caseValueProductCustomAttributeIndex = "asset_group_listing_group_filter.case_value.product_custom_attribute.index";
        public static final String caseValueProductCustomAttributeValue = "asset_group_listing_group_filter.case_value.product_custom_attribute.value";
        public static final String caseValueProductItemIdValue = "asset_group_listing_group_filter.case_value.product_item_id.value";
        public static final String caseValueProductTypeLevel = "asset_group_listing_group_filter.case_value.product_type.level";
        public static final String caseValueProductTypeValue = "asset_group_listing_group_filter.case_value.product_type.value";
        public static final String caseValueWebpageConditions = "asset_group_listing_group_filter.case_value.webpage.conditions";
        public static final String id = "asset_group_listing_group_filter.id";
        public static final String listingSource = "asset_group_listing_group_filter.listing_source";
        public static final String parentListingGroupFilter = "asset_group_listing_group_filter.parent_listing_group_filter";
        public static final String path = "asset_group_listing_group_filter.path";
        public static final String resourceName = "asset_group_listing_group_filter.resource_name";
        public static final String type = "asset_group_listing_group_filter.type";
    }

    public static class AssetGroupProductGroupView {
        public static final String assetGroup = "asset_group_product_group_view.asset_group";
        public static final String assetGroupListingGroupFilter = "asset_group_product_group_view.asset_group_listing_group_filter";
        public static final String resourceName = "asset_group_product_group_view.resource_name";
    }

    public static class AssetGroupSignal {
        public static final String approvalStatus = "asset_group_signal.approval_status";
        public static final String assetGroup = "asset_group_signal.asset_group";
        public static final String audienceAudience = "asset_group_signal.audience.audience";
        public static final String disapprovalReasons = "asset_group_signal.disapproval_reasons";
        public static final String resourceName = "asset_group_signal.resource_name";
        public static final String searchThemeText = "asset_group_signal.search_theme.text";
    }

    public static class AssetGroupTopCombinationView {
        public static final String assetGroupTopCombinations = "asset_group_top_combination_view.asset_group_top_combinations";
        public static final String resourceName = "asset_group_top_combination_view.resource_name";
    }

    public static class AssetSet {
        public static final String businessProfileLocationGroupDynamicBusinessProfileLocationGroupFilterBusinessNameFilterBusinessName = "asset_set.business_profile_location_group.dynamic_business_profile_location_group_filter.business_name_filter.business_name";
        public static final String businessProfileLocationGroupDynamicBusinessProfileLocationGroupFilterBusinessNameFilterFilterType = "asset_set.business_profile_location_group.dynamic_business_profile_location_group_filter.business_name_filter.filter_type";
        public static final String businessProfileLocationGroupDynamicBusinessProfileLocationGroupFilterLabelFilters = "asset_set.business_profile_location_group.dynamic_business_profile_location_group_filter.label_filters";
        public static final String businessProfileLocationGroupDynamicBusinessProfileLocationGroupFilterListingIdFilters = "asset_set.business_profile_location_group.dynamic_business_profile_location_group_filter.listing_id_filters";
        public static final String hotelPropertyDataHotelCenterId = "asset_set.hotel_property_data.hotel_center_id";
        public static final String hotelPropertyDataPartnerName = "asset_set.hotel_property_data.partner_name";
        public static final String id = "asset_set.id";
        public static final String locationGroupParentAssetSetId = "asset_set.location_group_parent_asset_set_id";
        public static final String locationSetBusinessProfileLocationSetBusinessNameFilter = "asset_set.location_set.business_profile_location_set.business_name_filter";
        public static final String locationSetBusinessProfileLocationSetLabelFilters = "asset_set.location_set.business_profile_location_set.label_filters";
        public static final String locationSetBusinessProfileLocationSetListingIdFilters = "asset_set.location_set.business_profile_location_set.listing_id_filters";
        public static final String locationSetChainLocationSetRelationshipType = "asset_set.location_set.chain_location_set.relationship_type";
        public static final String locationSetLocationOwnershipType = "asset_set.location_set.location_ownership_type";
        public static final String merchantCenterFeedFeedLabel = "asset_set.merchant_center_feed.feed_label";
        public static final String merchantCenterFeedMerchantId = "asset_set.merchant_center_feed.merchant_id";
        public static final String name = "asset_set.name";
        public static final String resourceName = "asset_set.resource_name";
        public static final String status = "asset_set.status";
        public static final String type = "asset_set.type";
    }

    public static class AssetSetAsset {
        public static final String asset = "asset_set_asset.asset";
        public static final String assetSet = "asset_set_asset.asset_set";
        public static final String resourceName = "asset_set_asset.resource_name";
        public static final String status = "asset_set_asset.status";
    }

    public static class AssetSetTypeView {
        public static final String assetSetType = "asset_set_type_view.asset_set_type";
        public static final String resourceName = "asset_set_type_view.resource_name";
    }

    public static class Audience {
        public static final String assetGroup = "audience.asset_group";
        public static final String description = "audience.description";
        public static final String dimensions = "audience.dimensions";
        public static final String dimensionsAudienceSegmentsSegmentsCustomAudienceCustomAudience = "audience.dimensions.audience_segments.segments.custom_audience.custom_audience";
        public static final String dimensionsAudienceSegmentsSegmentsDetailedDemographicDetailedDemographic = "audience.dimensions.audience_segments.segments.detailed_demographic.detailed_demographic";
        public static final String dimensionsAudienceSegmentsSegmentsLifeEventLifeEvent = "audience.dimensions.audience_segments.segments.life_event.life_event";
        public static final String dimensionsAudienceSegmentsSegmentsUserInterestUserInterestCategory = "audience.dimensions.audience_segments.segments.user_interest.user_interest_category";
        public static final String dimensionsAudienceSegmentsSegmentsUserListUserList = "audience.dimensions.audience_segments.segments.user_list.user_list";
        public static final String exclusionDimension = "audience.exclusion_dimension";
        public static final String exclusionDimensionExclusionsUserListUserList = "audience.exclusion_dimension.exclusions.user_list.user_list";
        public static final String id = "audience.id";
        public static final String name = "audience.name";
        public static final String resourceName = "audience.resource_name";
        public static final String scope = "audience.scope";
        public static final String status = "audience.status";
    }

    public static class BatchJob {
        public static final String id = "batch_job.id";
        public static final String longRunningOperation = "batch_job.long_running_operation";
        public static final String metadataCompletionDateTime = "batch_job.metadata.completion_date_time";
        public static final String metadataCreationDateTime = "batch_job.metadata.creation_date_time";
        public static final String metadataEstimatedCompletionRatio = "batch_job.metadata.estimated_completion_ratio";
        public static final String metadataExecutedOperationCount = "batch_job.metadata.executed_operation_count";
        public static final String metadataExecutionLimitSeconds = "batch_job.metadata.execution_limit_seconds";
        public static final String metadataOperationCount = "batch_job.metadata.operation_count";
        public static final String metadataStartDateTime = "batch_job.metadata.start_date_time";
        public static final String nextAddSequenceToken = "batch_job.next_add_sequence_token";
        public static final String resourceName = "batch_job.resource_name";
        public static final String status = "batch_job.status";
    }

    public static class BiddingDataExclusion {
        public static final String advertisingChannelTypes = "bidding_data_exclusion.advertising_channel_types";
        public static final String campaigns = "bidding_data_exclusion.campaigns";
        public static final String dataExclusionId = "bidding_data_exclusion.data_exclusion_id";
        public static final String description = "bidding_data_exclusion.description";
        public static final String devices = "bidding_data_exclusion.devices";
        public static final String endDateTime = "bidding_data_exclusion.end_date_time";
        public static final String name = "bidding_data_exclusion.name";
        public static final String resourceName = "bidding_data_exclusion.resource_name";
        public static final String scope = "bidding_data_exclusion.scope";
        public static final String startDateTime = "bidding_data_exclusion.start_date_time";
        public static final String status = "bidding_data_exclusion.status";
    }

    public static class BiddingSeasonalityAdjustment {
        public static final String advertisingChannelTypes = "bidding_seasonality_adjustment.advertising_channel_types";
        public static final String campaigns = "bidding_seasonality_adjustment.campaigns";
        public static final String conversionRateModifier = "bidding_seasonality_adjustment.conversion_rate_modifier";
        public static final String description = "bidding_seasonality_adjustment.description";
        public static final String devices = "bidding_seasonality_adjustment.devices";
        public static final String endDateTime = "bidding_seasonality_adjustment.end_date_time";
        public static final String name = "bidding_seasonality_adjustment.name";
        public static final String resourceName = "bidding_seasonality_adjustment.resource_name";
        public static final String scope = "bidding_seasonality_adjustment.scope";
        public static final String seasonalityAdjustmentId = "bidding_seasonality_adjustment.seasonality_adjustment_id";
        public static final String startDateTime = "bidding_seasonality_adjustment.start_date_time";
        public static final String status = "bidding_seasonality_adjustment.status";
    }

    public static class BiddingStrategy {
        public static final String alignedCampaignBudgetId = "bidding_strategy.aligned_campaign_budget_id";
        public static final String campaignCount = "bidding_strategy.campaign_count";
        public static final String currencyCode = "bidding_strategy.currency_code";
        public static final String effectiveCurrencyCode = "bidding_strategy.effective_currency_code";
        public static final String enhancedCpc = "bidding_strategy.enhanced_cpc";
        public static final String id = "bidding_strategy.id";
        public static final String maximizeConversionValueCpcBidCeilingMicros = "bidding_strategy.maximize_conversion_value.cpc_bid_ceiling_micros";
        public static final String maximizeConversionValueCpcBidFloorMicros = "bidding_strategy.maximize_conversion_value.cpc_bid_floor_micros";
        public static final String maximizeConversionValueTargetRoas = "bidding_strategy.maximize_conversion_value.target_roas";
        public static final String maximizeConversionsCpcBidCeilingMicros = "bidding_strategy.maximize_conversions.cpc_bid_ceiling_micros";
        public static final String maximizeConversionsCpcBidFloorMicros = "bidding_strategy.maximize_conversions.cpc_bid_floor_micros";
        public static final String maximizeConversionsTargetCpaMicros = "bidding_strategy.maximize_conversions.target_cpa_micros";
        public static final String name = "bidding_strategy.name";
        public static final String nonRemovedCampaignCount = "bidding_strategy.non_removed_campaign_count";
        public static final String resourceName = "bidding_strategy.resource_name";
        public static final String status = "bidding_strategy.status";
        public static final String targetCpaCpcBidCeilingMicros = "bidding_strategy.target_cpa.cpc_bid_ceiling_micros";
        public static final String targetCpaCpcBidFloorMicros = "bidding_strategy.target_cpa.cpc_bid_floor_micros";
        public static final String targetCpaTargetCpaMicros = "bidding_strategy.target_cpa.target_cpa_micros";
        public static final String targetImpressionShareCpcBidCeilingMicros = "bidding_strategy.target_impression_share.cpc_bid_ceiling_micros";
        public static final String targetImpressionShareLocation = "bidding_strategy.target_impression_share.location";
        public static final String targetImpressionShareLocationFractionMicros = "bidding_strategy.target_impression_share.location_fraction_micros";
        public static final String targetRoasCpcBidCeilingMicros = "bidding_strategy.target_roas.cpc_bid_ceiling_micros";
        public static final String targetRoasCpcBidFloorMicros = "bidding_strategy.target_roas.cpc_bid_floor_micros";
        public static final String targetRoasTargetRoas = "bidding_strategy.target_roas.target_roas";
        public static final String targetSpendCpcBidCeilingMicros = "bidding_strategy.target_spend.cpc_bid_ceiling_micros";
        public static final String targetSpendTargetSpendMicros = "bidding_strategy.target_spend.target_spend_micros";
        public static final String type = "bidding_strategy.type";
    }

    public static class BiddingStrategySimulation {
        public static final String biddingStrategyId = "bidding_strategy_simulation.bidding_strategy_id";
        public static final String endDate = "bidding_strategy_simulation.end_date";
        public static final String modificationMethod = "bidding_strategy_simulation.modification_method";
        public static final String resourceName = "bidding_strategy_simulation.resource_name";
        public static final String startDate = "bidding_strategy_simulation.start_date";
        public static final String targetCpaPointListPoints = "bidding_strategy_simulation.target_cpa_point_list.points";
        public static final String targetRoasPointListPoints = "bidding_strategy_simulation.target_roas_point_list.points";
        public static final String type = "bidding_strategy_simulation.type";
    }

    public static class BillingSetup {
        public static final String endDateTime = "billing_setup.end_date_time";
        public static final String endTimeType = "billing_setup.end_time_type";
        public static final String id = "billing_setup.id";
        public static final String paymentsAccount = "billing_setup.payments_account";
        public static final String paymentsAccountInfoPaymentsAccountId = "billing_setup.payments_account_info.payments_account_id";
        public static final String paymentsAccountInfoPaymentsAccountName = "billing_setup.payments_account_info.payments_account_name";
        public static final String paymentsAccountInfoPaymentsProfileId = "billing_setup.payments_account_info.payments_profile_id";
        public static final String paymentsAccountInfoPaymentsProfileName = "billing_setup.payments_account_info.payments_profile_name";
        public static final String paymentsAccountInfoSecondaryPaymentsProfileId = "billing_setup.payments_account_info.secondary_payments_profile_id";
        public static final String resourceName = "billing_setup.resource_name";
        public static final String startDateTime = "billing_setup.start_date_time";
        public static final String status = "billing_setup.status";
    }

    public static class CallView {
        public static final String callDurationSeconds = "call_view.call_duration_seconds";
        public static final String callStatus = "call_view.call_status";
        public static final String callTrackingDisplayLocation = "call_view.call_tracking_display_location";
        public static final String callerAreaCode = "call_view.caller_area_code";
        public static final String callerCountryCode = "call_view.caller_country_code";
        public static final String endCallDateTime = "call_view.end_call_date_time";
        public static final String resourceName = "call_view.resource_name";
        public static final String startCallDateTime = "call_view.start_call_date_time";
        public static final String type = "call_view.type";
    }

    public static class Campaign {
        public static final String accessibleBiddingStrategy = "campaign.accessible_bidding_strategy";
        public static final String adServingOptimizationStatus = "campaign.ad_serving_optimization_status";
        public static final String advertisingChannelSubType = "campaign.advertising_channel_sub_type";
        public static final String advertisingChannelType = "campaign.advertising_channel_type";
        public static final String appCampaignSettingAppId = "campaign.app_campaign_setting.app_id";
        public static final String appCampaignSettingAppStore = "campaign.app_campaign_setting.app_store";
        public static final String appCampaignSettingBiddingStrategyGoalType = "campaign.app_campaign_setting.bidding_strategy_goal_type";
        public static final String assetAutomationSettings = "campaign.asset_automation_settings";
        public static final String audienceSettingUseAudienceGrouped = "campaign.audience_setting.use_audience_grouped";
        public static final String baseCampaign = "campaign.base_campaign";
        public static final String biddingStrategy = "campaign.bidding_strategy";
        public static final String biddingStrategySystemStatus = "campaign.bidding_strategy_system_status";
        public static final String biddingStrategyType = "campaign.bidding_strategy_type";
        public static final String campaignBudget = "campaign.campaign_budget";
        public static final String campaignGroup = "campaign.campaign_group";
        public static final String commissionCommissionRateMicros = "campaign.commission.commission_rate_micros";
        public static final String discoveryCampaignSettingsUpgradedTargeting = "campaign.discovery_campaign_settings.upgraded_targeting";
        public static final String dynamicSearchAdsSettingDomainName = "campaign.dynamic_search_ads_setting.domain_name";
        public static final String dynamicSearchAdsSettingFeeds = "campaign.dynamic_search_ads_setting.feeds";
        public static final String dynamicSearchAdsSettingLanguageCode = "campaign.dynamic_search_ads_setting.language_code";
        public static final String dynamicSearchAdsSettingUseSuppliedUrlsOnly = "campaign.dynamic_search_ads_setting.use_supplied_urls_only";
        public static final String endDate = "campaign.end_date";
        public static final String excludedParentAssetFieldTypes = "campaign.excluded_parent_asset_field_types";
        public static final String excludedParentAssetSetTypes = "campaign.excluded_parent_asset_set_types";
        public static final String experimentType = "campaign.experiment_type";
        public static final String finalUrlSuffix = "campaign.final_url_suffix";
        public static final String frequencyCaps = "campaign.frequency_caps";
        public static final String geoTargetTypeSettingNegativeGeoTargetType = "campaign.geo_target_type_setting.negative_geo_target_type";
        public static final String geoTargetTypeSettingPositiveGeoTargetType = "campaign.geo_target_type_setting.positive_geo_target_type";
        public static final String hotelPropertyAssetSet = "campaign.hotel_property_asset_set";
        public static final String hotelSettingHotelCenterId = "campaign.hotel_setting.hotel_center_id";
        public static final String id = "campaign.id";
        public static final String labels = "campaign.labels";
        public static final String listingType = "campaign.listing_type";
        public static final String localCampaignSettingLocationSourceType = "campaign.local_campaign_setting.location_source_type";
        public static final String localServicesCampaignSettingsCategoryBids = "campaign.local_services_campaign_settings.category_bids";
        public static final String manualCpa = "campaign.manual_cpa";
        public static final String manualCpcEnhancedCpcEnabled = "campaign.manual_cpc.enhanced_cpc_enabled";
        public static final String manualCpm = "campaign.manual_cpm";
        public static final String manualCpv = "campaign.manual_cpv";
        public static final String maximizeConversionValueTargetRoas = "campaign.maximize_conversion_value.target_roas";
        public static final String maximizeConversionsTargetCpaMicros = "campaign.maximize_conversions.target_cpa_micros";
        public static final String name = "campaign.name";
        public static final String networkSettingsTargetContentNetwork = "campaign.network_settings.target_content_network";
        public static final String networkSettingsTargetGoogleSearch = "campaign.network_settings.target_google_search";
        public static final String networkSettingsTargetGoogleTvNetwork = "campaign.network_settings.target_google_tv_network";
        public static final String networkSettingsTargetPartnerSearchNetwork = "campaign.network_settings.target_partner_search_network";
        public static final String networkSettingsTargetSearchNetwork = "campaign.network_settings.target_search_network";
        public static final String networkSettingsTargetYoutube = "campaign.network_settings.target_youtube";
        public static final String optimizationGoalSettingOptimizationGoalTypes = "campaign.optimization_goal_setting.optimization_goal_types";
        public static final String optimizationScore = "campaign.optimization_score";
        public static final String paymentMode = "campaign.payment_mode";
        public static final String percentCpcCpcBidCeilingMicros = "campaign.percent_cpc.cpc_bid_ceiling_micros";
        public static final String percentCpcEnhancedCpcEnabled = "campaign.percent_cpc.enhanced_cpc_enabled";
        public static final String performanceMaxUpgradePerformanceMaxCampaign = "campaign.performance_max_upgrade.performance_max_campaign";
        public static final String performanceMaxUpgradePreUpgradeCampaign = "campaign.performance_max_upgrade.pre_upgrade_campaign";
        public static final String performanceMaxUpgradeStatus = "campaign.performance_max_upgrade.status";
        public static final String primaryStatus = "campaign.primary_status";
        public static final String primaryStatusReasons = "campaign.primary_status_reasons";
        public static final String realTimeBiddingSettingOptIn = "campaign.real_time_bidding_setting.opt_in";
        public static final String resourceName = "campaign.resource_name";
        public static final String selectiveOptimizationConversionActions = "campaign.selective_optimization.conversion_actions";
        public static final String servingStatus = "campaign.serving_status";
        public static final String shoppingSettingAdvertisingPartnerIds = "campaign.shopping_setting.advertising_partner_ids";
        public static final String shoppingSettingCampaignPriority = "campaign.shopping_setting.campaign_priority";
        public static final String shoppingSettingDisableProductFeed = "campaign.shopping_setting.disable_product_feed";
        public static final String shoppingSettingEnableLocal = "campaign.shopping_setting.enable_local";
        public static final String shoppingSettingFeedLabel = "campaign.shopping_setting.feed_label";
        public static final String shoppingSettingMerchantId = "campaign.shopping_setting.merchant_id";
        public static final String shoppingSettingUseVehicleInventory = "campaign.shopping_setting.use_vehicle_inventory";
        public static final String startDate = "campaign.start_date";
        public static final String status = "campaign.status";
        public static final String targetCpaCpcBidCeilingMicros = "campaign.target_cpa.cpc_bid_ceiling_micros";
        public static final String targetCpaCpcBidFloorMicros = "campaign.target_cpa.cpc_bid_floor_micros";
        public static final String targetCpaTargetCpaMicros = "campaign.target_cpa.target_cpa_micros";
        public static final String targetCpmTargetFrequencyGoalTargetCount = "campaign.target_cpm.target_frequency_goal.target_count";
        public static final String targetCpmTargetFrequencyGoalTimeUnit = "campaign.target_cpm.target_frequency_goal.time_unit";
        public static final String targetImpressionShareCpcBidCeilingMicros = "campaign.target_impression_share.cpc_bid_ceiling_micros";
        public static final String targetImpressionShareLocation = "campaign.target_impression_share.location";
        public static final String targetImpressionShareLocationFractionMicros = "campaign.target_impression_share.location_fraction_micros";
        public static final String targetRoasCpcBidCeilingMicros = "campaign.target_roas.cpc_bid_ceiling_micros";
        public static final String targetRoasCpcBidFloorMicros = "campaign.target_roas.cpc_bid_floor_micros";
        public static final String targetRoasTargetRoas = "campaign.target_roas.target_roas";
        public static final String targetSpendCpcBidCeilingMicros = "campaign.target_spend.cpc_bid_ceiling_micros";
        public static final String targetSpendTargetSpendMicros = "campaign.target_spend.target_spend_micros";
        public static final String targetingSettingTargetRestrictions = "campaign.targeting_setting.target_restrictions";
        public static final String trackingSettingTrackingUrl = "campaign.tracking_setting.tracking_url";
        public static final String trackingUrlTemplate = "campaign.tracking_url_template";
        public static final String travelCampaignSettingsTravelAccountId = "campaign.travel_campaign_settings.travel_account_id";
        public static final String urlCustomParameters = "campaign.url_custom_parameters";
        public static final String urlExpansionOptOut = "campaign.url_expansion_opt_out";
        public static final String vanityPharmaVanityPharmaDisplayUrlMode = "campaign.vanity_pharma.vanity_pharma_display_url_mode";
        public static final String vanityPharmaVanityPharmaText = "campaign.vanity_pharma.vanity_pharma_text";
        public static final String videoBrandSafetySuitability = "campaign.video_brand_safety_suitability";
    }

    public static class CampaignAsset {
        public static final String asset = "campaign_asset.asset";
        public static final String campaign = "campaign_asset.campaign";
        public static final String fieldType = "campaign_asset.field_type";
        public static final String primaryStatus = "campaign_asset.primary_status";
        public static final String primaryStatusDetails = "campaign_asset.primary_status_details";
        public static final String primaryStatusReasons = "campaign_asset.primary_status_reasons";
        public static final String resourceName = "campaign_asset.resource_name";
        public static final String source = "campaign_asset.source";
        public static final String status = "campaign_asset.status";
    }

    public static class CampaignAssetSet {
        public static final String assetSet = "campaign_asset_set.asset_set";
        public static final String campaign = "campaign_asset_set.campaign";
        public static final String resourceName = "campaign_asset_set.resource_name";
        public static final String status = "campaign_asset_set.status";
    }

    public static class CampaignAudienceView {
        public static final String resourceName = "campaign_audience_view.resource_name";
    }

    public static class CampaignBidModifier {
        public static final String bidModifier = "campaign_bid_modifier.bid_modifier";
        public static final String campaign = "campaign_bid_modifier.campaign";
        public static final String criterionId = "campaign_bid_modifier.criterion_id";
        public static final String interactionTypeType = "campaign_bid_modifier.interaction_type.type";
        public static final String resourceName = "campaign_bid_modifier.resource_name";
    }

    public static class CampaignBudget {
        public static final String alignedBiddingStrategyId = "campaign_budget.aligned_bidding_strategy_id";
        public static final String amountMicros = "campaign_budget.amount_micros";
        public static final String deliveryMethod = "campaign_budget.delivery_method";
        public static final String explicitlyShared = "campaign_budget.explicitly_shared";
        public static final String hasRecommendedBudget = "campaign_budget.has_recommended_budget";
        public static final String id = "campaign_budget.id";
        public static final String name = "campaign_budget.name";
        public static final String period = "campaign_budget.period";
        public static final String recommendedBudgetAmountMicros = "campaign_budget.recommended_budget_amount_micros";
        public static final String recommendedBudgetEstimatedChangeWeeklyClicks = "campaign_budget.recommended_budget_estimated_change_weekly_clicks";
        public static final String recommendedBudgetEstimatedChangeWeeklyCostMicros = "campaign_budget.recommended_budget_estimated_change_weekly_cost_micros";
        public static final String recommendedBudgetEstimatedChangeWeeklyInteractions = "campaign_budget.recommended_budget_estimated_change_weekly_interactions";
        public static final String recommendedBudgetEstimatedChangeWeeklyViews = "campaign_budget.recommended_budget_estimated_change_weekly_views";
        public static final String referenceCount = "campaign_budget.reference_count";
        public static final String resourceName = "campaign_budget.resource_name";
        public static final String status = "campaign_budget.status";
        public static final String totalAmountMicros = "campaign_budget.total_amount_micros";
        public static final String type = "campaign_budget.type";
    }

    public static class CampaignConversionGoal {
        public static final String biddable = "campaign_conversion_goal.biddable";
        public static final String campaign = "campaign_conversion_goal.campaign";
        public static final String category = "campaign_conversion_goal.category";
        public static final String origin = "campaign_conversion_goal.origin";
        public static final String resourceName = "campaign_conversion_goal.resource_name";
    }

    public static class CampaignCriterion {
        public static final String adScheduleDayOfWeek = "campaign_criterion.ad_schedule.day_of_week";
        public static final String adScheduleEndHour = "campaign_criterion.ad_schedule.end_hour";
        public static final String adScheduleEndMinute = "campaign_criterion.ad_schedule.end_minute";
        public static final String adScheduleStartHour = "campaign_criterion.ad_schedule.start_hour";
        public static final String adScheduleStartMinute = "campaign_criterion.ad_schedule.start_minute";
        public static final String ageRangeType = "campaign_criterion.age_range.type";
        public static final String bidModifier = "campaign_criterion.bid_modifier";
        public static final String brandListSharedSet = "campaign_criterion.brand_list.shared_set";
        public static final String campaign = "campaign_criterion.campaign";
        public static final String carrierCarrierConstant = "campaign_criterion.carrier.carrier_constant";
        public static final String combinedAudienceCombinedAudience = "campaign_criterion.combined_audience.combined_audience";
        public static final String contentLabelType = "campaign_criterion.content_label.type";
        public static final String criterionId = "campaign_criterion.criterion_id";
        public static final String customAffinityCustomAffinity = "campaign_criterion.custom_affinity.custom_affinity";
        public static final String customAudienceCustomAudience = "campaign_criterion.custom_audience.custom_audience";
        public static final String deviceType = "campaign_criterion.device.type";
        public static final String displayName = "campaign_criterion.display_name";
        public static final String genderType = "campaign_criterion.gender.type";
        public static final String incomeRangeType = "campaign_criterion.income_range.type";
        public static final String ipBlockIpAddress = "campaign_criterion.ip_block.ip_address";
        public static final String keywordMatchType = "campaign_criterion.keyword.match_type";
        public static final String keywordText = "campaign_criterion.keyword.text";
        public static final String keywordThemeFreeFormKeywordTheme = "campaign_criterion.keyword_theme.free_form_keyword_theme";
        public static final String keywordThemeKeywordThemeConstant = "campaign_criterion.keyword_theme.keyword_theme_constant";
        public static final String languageLanguageConstant = "campaign_criterion.language.language_constant";
        public static final String listingScopeDimensions = "campaign_criterion.listing_scope.dimensions";
        public static final String listingScopeDimensionsActivityCityValue = "campaign_criterion.listing_scope.dimensions.activity_city.value";
        public static final String listingScopeDimensionsActivityCountryValue = "campaign_criterion.listing_scope.dimensions.activity_country.value";
        public static final String listingScopeDimensionsActivityStateValue = "campaign_criterion.listing_scope.dimensions.activity_state.value";
        public static final String listingScopeDimensionsHotelCityCityCriterion = "campaign_criterion.listing_scope.dimensions.hotel_city.city_criterion";
        public static final String listingScopeDimensionsHotelCountryRegionCountryRegionCriterion = "campaign_criterion.listing_scope.dimensions.hotel_country_region.country_region_criterion";
        public static final String listingScopeDimensionsHotelStateStateCriterion = "campaign_criterion.listing_scope.dimensions.hotel_state.state_criterion";
        public static final String localServiceIdServiceId = "campaign_criterion.local_service_id.service_id";
        public static final String locationGeoTargetConstant = "campaign_criterion.location.geo_target_constant";
        public static final String locationGroup = "campaign_criterion.location_group";
        public static final String locationGroupEnableCustomerLevelLocationAssetSet = "campaign_criterion.location_group.enable_customer_level_location_asset_set";
        public static final String locationGroupFeed = "campaign_criterion.location_group.feed";
        public static final String locationGroupGeoTargetConstants = "campaign_criterion.location_group.geo_target_constants";
        public static final String mobileAppCategoryMobileAppCategoryConstant = "campaign_criterion.mobile_app_category.mobile_app_category_constant";
        public static final String mobileApplicationAppId = "campaign_criterion.mobile_application.app_id";
        public static final String mobileApplicationName = "campaign_criterion.mobile_application.name";
        public static final String mobileDeviceMobileDeviceConstant = "campaign_criterion.mobile_device.mobile_device_constant";
        public static final String negative = "campaign_criterion.negative";
        public static final String operatingSystemVersionOperatingSystemVersionConstant = "campaign_criterion.operating_system_version.operating_system_version_constant";
        public static final String parentalStatusType = "campaign_criterion.parental_status.type";
        public static final String placementUrl = "campaign_criterion.placement.url";
        public static final String proximityAddressCityName = "campaign_criterion.proximity.address.city_name";
        public static final String proximityAddressCountryCode = "campaign_criterion.proximity.address.country_code";
        public static final String proximityAddressPostalCode = "campaign_criterion.proximity.address.postal_code";
        public static final String proximityAddressProvinceCode = "campaign_criterion.proximity.address.province_code";
        public static final String proximityAddressProvinceName = "campaign_criterion.proximity.address.province_name";
        public static final String proximityAddressStreetAddress = "campaign_criterion.proximity.address.street_address";
        public static final String proximityGeoPointLatitudeInMicroDegrees = "campaign_criterion.proximity.geo_point.latitude_in_micro_degrees";
        public static final String proximityGeoPointLongitudeInMicroDegrees = "campaign_criterion.proximity.geo_point.longitude_in_micro_degrees";
        public static final String proximityRadius = "campaign_criterion.proximity.radius";
        public static final String proximityRadiusUnits = "campaign_criterion.proximity.radius_units";
        public static final String resourceName = "campaign_criterion.resource_name";
        public static final String status = "campaign_criterion.status";
        public static final String topicPath = "campaign_criterion.topic.path";
        public static final String topicTopicConstant = "campaign_criterion.topic.topic_constant";
        public static final String type = "campaign_criterion.type";
        public static final String userInterestUserInterestCategory = "campaign_criterion.user_interest.user_interest_category";
        public static final String userListUserList = "campaign_criterion.user_list.user_list";
        public static final String webpageConditions = "campaign_criterion.webpage.conditions";
        public static final String webpageCoveragePercentage = "campaign_criterion.webpage.coverage_percentage";
        public static final String webpageCriterionName = "campaign_criterion.webpage.criterion_name";
        public static final String webpageSampleSampleUrls = "campaign_criterion.webpage.sample.sample_urls";
        public static final String youtubeChannelChannelId = "campaign_criterion.youtube_channel.channel_id";
        public static final String youtubeVideoVideoId = "campaign_criterion.youtube_video.video_id";
    }

    public static class CampaignCustomizer {
        public static final String campaign = "campaign_customizer.campaign";
        public static final String customizerAttribute = "campaign_customizer.customizer_attribute";
        public static final String resourceName = "campaign_customizer.resource_name";
        public static final String status = "campaign_customizer.status";
        public static final String valueStringValue = "campaign_customizer.value.string_value";
        public static final String valueType = "campaign_customizer.value.type";
    }

    public static class CampaignDraft {
        public static final String baseCampaign = "campaign_draft.base_campaign";
        public static final String draftCampaign = "campaign_draft.draft_campaign";
        public static final String draftId = "campaign_draft.draft_id";
        public static final String hasExperimentRunning = "campaign_draft.has_experiment_running";
        public static final String longRunningOperation = "campaign_draft.long_running_operation";
        public static final String name = "campaign_draft.name";
        public static final String resourceName = "campaign_draft.resource_name";
        public static final String status = "campaign_draft.status";
    }

    public static class CampaignExtensionSetting {
        public static final String campaign = "campaign_extension_setting.campaign";
        public static final String device = "campaign_extension_setting.device";
        public static final String extensionFeedItems = "campaign_extension_setting.extension_feed_items";
        public static final String extensionType = "campaign_extension_setting.extension_type";
        public static final String resourceName = "campaign_extension_setting.resource_name";
    }

    public static class CampaignFeed {
        public static final String campaign = "campaign_feed.campaign";
        public static final String feed = "campaign_feed.feed";
        public static final String matchingFunctionFunctionString = "campaign_feed.matching_function.function_string";
        public static final String matchingFunctionLeftOperands = "campaign_feed.matching_function.left_operands";
        public static final String matchingFunctionOperator = "campaign_feed.matching_function.operator";
        public static final String matchingFunctionRightOperands = "campaign_feed.matching_function.right_operands";
        public static final String placeholderTypes = "campaign_feed.placeholder_types";
        public static final String resourceName = "campaign_feed.resource_name";
        public static final String status = "campaign_feed.status";
    }

    public static class CampaignGroup {
        public static final String id = "campaign_group.id";
        public static final String name = "campaign_group.name";
        public static final String resourceName = "campaign_group.resource_name";
        public static final String status = "campaign_group.status";
    }

    public static class CampaignLabel {
        public static final String campaign = "campaign_label.campaign";
        public static final String label = "campaign_label.label";
        public static final String resourceName = "campaign_label.resource_name";
    }

    public static class CampaignLifecycleGoal {
        public static final String campaign = "campaign_lifecycle_goal.campaign";
        public static final String customerAcquisitionGoalSettingsOptimizationMode = "campaign_lifecycle_goal.customer_acquisition_goal_settings.optimization_mode";
        public static final String customerAcquisitionGoalSettingsValueSettingsHighLifetimeValue = "campaign_lifecycle_goal.customer_acquisition_goal_settings.value_settings.high_lifetime_value";
        public static final String customerAcquisitionGoalSettingsValueSettingsValue = "campaign_lifecycle_goal.customer_acquisition_goal_settings.value_settings.value";
        public static final String resourceName = "campaign_lifecycle_goal.resource_name";
    }

    public static class CampaignSearchTermInsight {
        public static final String campaignId = "campaign_search_term_insight.campaign_id";
        public static final String categoryLabel = "campaign_search_term_insight.category_label";
        public static final String id = "campaign_search_term_insight.id";
        public static final String resourceName = "campaign_search_term_insight.resource_name";
    }

    public static class CampaignSharedSet {
        public static final String campaign = "campaign_shared_set.campaign";
        public static final String resourceName = "campaign_shared_set.resource_name";
        public static final String sharedSet = "campaign_shared_set.shared_set";
        public static final String status = "campaign_shared_set.status";
    }

    public static class CampaignSimulation {
        public static final String budgetPointListPoints = "campaign_simulation.budget_point_list.points";
        public static final String campaignId = "campaign_simulation.campaign_id";
        public static final String cpcBidPointListPoints = "campaign_simulation.cpc_bid_point_list.points";
        public static final String endDate = "campaign_simulation.end_date";
        public static final String modificationMethod = "campaign_simulation.modification_method";
        public static final String resourceName = "campaign_simulation.resource_name";
        public static final String startDate = "campaign_simulation.start_date";
        public static final String targetCpaPointListPoints = "campaign_simulation.target_cpa_point_list.points";
        public static final String targetImpressionSharePointListPoints = "campaign_simulation.target_impression_share_point_list.points";
        public static final String targetRoasPointListPoints = "campaign_simulation.target_roas_point_list.points";
        public static final String type = "campaign_simulation.type";
    }

    public static class CarrierConstant {
        public static final String countryCode = "carrier_constant.country_code";
        public static final String id = "carrier_constant.id";
        public static final String name = "carrier_constant.name";
        public static final String resourceName = "carrier_constant.resource_name";
    }

    public static class ChangeEvent {
        public static final String adGroup = "change_event.ad_group";
        public static final String asset = "change_event.asset";
        public static final String campaign = "change_event.campaign";
        public static final String changeDateTime = "change_event.change_date_time";
        public static final String changeResourceName = "change_event.change_resource_name";
        public static final String changeResourceType = "change_event.change_resource_type";
        public static final String changedFields = "change_event.changed_fields";
        public static final String clientType = "change_event.client_type";
        public static final String feed = "change_event.feed";
        public static final String feedItem = "change_event.feed_item";
        public static final String newResource = "change_event.new_resource";
        public static final String oldResource = "change_event.old_resource";
        public static final String resourceChangeOperation = "change_event.resource_change_operation";
        public static final String resourceName = "change_event.resource_name";
        public static final String userEmail = "change_event.user_email";
    }

    public static class ChangeStatus {
        public static final String adGroup = "change_status.ad_group";
        public static final String adGroupAd = "change_status.ad_group_ad";
        public static final String adGroupAsset = "change_status.ad_group_asset";
        public static final String adGroupBidModifier = "change_status.ad_group_bid_modifier";
        public static final String adGroupCriterion = "change_status.ad_group_criterion";
        public static final String adGroupFeed = "change_status.ad_group_feed";
        public static final String asset = "change_status.asset";
        public static final String campaign = "change_status.campaign";
        public static final String campaignAsset = "change_status.campaign_asset";
        public static final String campaignCriterion = "change_status.campaign_criterion";
        public static final String campaignFeed = "change_status.campaign_feed";
        public static final String campaignSharedSet = "change_status.campaign_shared_set";
        public static final String combinedAudience = "change_status.combined_audience";
        public static final String customerAsset = "change_status.customer_asset";
        public static final String feed = "change_status.feed";
        public static final String feedItem = "change_status.feed_item";
        public static final String lastChangeDateTime = "change_status.last_change_date_time";
        public static final String resourceName = "change_status.resource_name";
        public static final String resourceStatus = "change_status.resource_status";
        public static final String resourceType = "change_status.resource_type";
        public static final String sharedSet = "change_status.shared_set";
    }

    public static class ClickView {
        public static final String adGroupAd = "click_view.ad_group_ad";
        public static final String areaOfInterestCity = "click_view.area_of_interest.city";
        public static final String areaOfInterestCountry = "click_view.area_of_interest.country";
        public static final String areaOfInterestMetro = "click_view.area_of_interest.metro";
        public static final String areaOfInterestMostSpecific = "click_view.area_of_interest.most_specific";
        public static final String areaOfInterestRegion = "click_view.area_of_interest.region";
        public static final String campaignLocationTarget = "click_view.campaign_location_target";
        public static final String gclid = "click_view.gclid";
        public static final String keyword = "click_view.keyword";
        public static final String keywordInfoMatchType = "click_view.keyword_info.match_type";
        public static final String keywordInfoText = "click_view.keyword_info.text";
        public static final String locationOfPresenceCity = "click_view.location_of_presence.city";
        public static final String locationOfPresenceCountry = "click_view.location_of_presence.country";
        public static final String locationOfPresenceMetro = "click_view.location_of_presence.metro";
        public static final String locationOfPresenceMostSpecific = "click_view.location_of_presence.most_specific";
        public static final String locationOfPresenceRegion = "click_view.location_of_presence.region";
        public static final String pageNumber = "click_view.page_number";
        public static final String resourceName = "click_view.resource_name";
        public static final String userList = "click_view.user_list";
    }

    public static class CombinedAudience {
        public static final String description = "combined_audience.description";
        public static final String id = "combined_audience.id";
        public static final String name = "combined_audience.name";
        public static final String resourceName = "combined_audience.resource_name";
        public static final String status = "combined_audience.status";
    }

    public static class ConversionAction {
        public static final String appId = "conversion_action.app_id";
        public static final String attributionModelSettingsAttributionModel = "conversion_action.attribution_model_settings.attribution_model";
        public static final String attributionModelSettingsDataDrivenModelStatus = "conversion_action.attribution_model_settings.data_driven_model_status";
        public static final String category = "conversion_action.category";
        public static final String clickThroughLookbackWindowDays = "conversion_action.click_through_lookback_window_days";
        public static final String countingType = "conversion_action.counting_type";
        public static final String firebaseSettingsEventName = "conversion_action.firebase_settings.event_name";
        public static final String firebaseSettingsProjectId = "conversion_action.firebase_settings.project_id";
        public static final String firebaseSettingsPropertyId = "conversion_action.firebase_settings.property_id";
        public static final String firebaseSettingsPropertyName = "conversion_action.firebase_settings.property_name";
        public static final String googleAnalytics4SettingsEventName = "conversion_action.google_analytics_4_settings.event_name";
        public static final String googleAnalytics4SettingsPropertyId = "conversion_action.google_analytics_4_settings.property_id";
        public static final String googleAnalytics4SettingsPropertyName = "conversion_action.google_analytics_4_settings.property_name";
        public static final String id = "conversion_action.id";
        public static final String includeInConversionsMetric = "conversion_action.include_in_conversions_metric";
        public static final String mobileAppVendor = "conversion_action.mobile_app_vendor";
        public static final String name = "conversion_action.name";
        public static final String origin = "conversion_action.origin";
        public static final String ownerCustomer = "conversion_action.owner_customer";
        public static final String phoneCallDurationSeconds = "conversion_action.phone_call_duration_seconds";
        public static final String primaryForGoal = "conversion_action.primary_for_goal";
        public static final String resourceName = "conversion_action.resource_name";
        public static final String status = "conversion_action.status";
        public static final String tagSnippets = "conversion_action.tag_snippets";
        public static final String thirdPartyAppAnalyticsSettingsEventName = "conversion_action.third_party_app_analytics_settings.event_name";
        public static final String thirdPartyAppAnalyticsSettingsProviderName = "conversion_action.third_party_app_analytics_settings.provider_name";
        public static final String type = "conversion_action.type";
        public static final String valueSettingsAlwaysUseDefaultValue = "conversion_action.value_settings.always_use_default_value";
        public static final String valueSettingsDefaultCurrencyCode = "conversion_action.value_settings.default_currency_code";
        public static final String valueSettingsDefaultValue = "conversion_action.value_settings.default_value";
        public static final String viewThroughLookbackWindowDays = "conversion_action.view_through_lookback_window_days";
    }

    public static class ConversionCustomVariable {
        public static final String id = "conversion_custom_variable.id";
        public static final String name = "conversion_custom_variable.name";
        public static final String ownerCustomer = "conversion_custom_variable.owner_customer";
        public static final String resourceName = "conversion_custom_variable.resource_name";
        public static final String status = "conversion_custom_variable.status";
        public static final String tag = "conversion_custom_variable.tag";
    }

    public static class ConversionGoalCampaignConfig {
        public static final String campaign = "conversion_goal_campaign_config.campaign";
        public static final String customConversionGoal = "conversion_goal_campaign_config.custom_conversion_goal";
        public static final String goalConfigLevel = "conversion_goal_campaign_config.goal_config_level";
        public static final String resourceName = "conversion_goal_campaign_config.resource_name";
    }

    public static class ConversionValueRule {
        public static final String actionOperation = "conversion_value_rule.action.operation";
        public static final String actionValue = "conversion_value_rule.action.value";
        public static final String audienceConditionUserInterests = "conversion_value_rule.audience_condition.user_interests";
        public static final String audienceConditionUserLists = "conversion_value_rule.audience_condition.user_lists";
        public static final String deviceConditionDeviceTypes = "conversion_value_rule.device_condition.device_types";
        public static final String geoLocationConditionExcludedGeoMatchType = "conversion_value_rule.geo_location_condition.excluded_geo_match_type";
        public static final String geoLocationConditionExcludedGeoTargetConstants = "conversion_value_rule.geo_location_condition.excluded_geo_target_constants";
        public static final String geoLocationConditionGeoMatchType = "conversion_value_rule.geo_location_condition.geo_match_type";
        public static final String geoLocationConditionGeoTargetConstants = "conversion_value_rule.geo_location_condition.geo_target_constants";
        public static final String id = "conversion_value_rule.id";
        public static final String ownerCustomer = "conversion_value_rule.owner_customer";
        public static final String resourceName = "conversion_value_rule.resource_name";
        public static final String status = "conversion_value_rule.status";
    }

    public static class ConversionValueRuleSet {
        public static final String attachmentType = "conversion_value_rule_set.attachment_type";
        public static final String campaign = "conversion_value_rule_set.campaign";
        public static final String conversionActionCategories = "conversion_value_rule_set.conversion_action_categories";
        public static final String conversionValueRules = "conversion_value_rule_set.conversion_value_rules";
        public static final String dimensions = "conversion_value_rule_set.dimensions";
        public static final String id = "conversion_value_rule_set.id";
        public static final String ownerCustomer = "conversion_value_rule_set.owner_customer";
        public static final String resourceName = "conversion_value_rule_set.resource_name";
        public static final String status = "conversion_value_rule_set.status";
    }

    public static class CurrencyConstant {
        public static final String billableUnitMicros = "currency_constant.billable_unit_micros";
        public static final String code = "currency_constant.code";
        public static final String name = "currency_constant.name";
        public static final String resourceName = "currency_constant.resource_name";
        public static final String symbol = "currency_constant.symbol";
    }

    public static class CustomAudience {
        public static final String description = "custom_audience.description";
        public static final String id = "custom_audience.id";
        public static final String members = "custom_audience.members";
        public static final String name = "custom_audience.name";
        public static final String resourceName = "custom_audience.resource_name";
        public static final String status = "custom_audience.status";
        public static final String type = "custom_audience.type";
    }

    public static class CustomConversionGoal {
        public static final String conversionActions = "custom_conversion_goal.conversion_actions";
        public static final String id = "custom_conversion_goal.id";
        public static final String name = "custom_conversion_goal.name";
        public static final String resourceName = "custom_conversion_goal.resource_name";
        public static final String status = "custom_conversion_goal.status";
    }

    public static class CustomInterest {
        public static final String description = "custom_interest.description";
        public static final String id = "custom_interest.id";
        public static final String members = "custom_interest.members";
        public static final String name = "custom_interest.name";
        public static final String resourceName = "custom_interest.resource_name";
        public static final String status = "custom_interest.status";
        public static final String type = "custom_interest.type";
    }

    public static class Customer {
        public static final String autoTaggingEnabled = "customer.auto_tagging_enabled";
        public static final String callReportingSettingCallConversionAction = "customer.call_reporting_setting.call_conversion_action";
        public static final String callReportingSettingCallConversionReportingEnabled = "customer.call_reporting_setting.call_conversion_reporting_enabled";
        public static final String callReportingSettingCallReportingEnabled = "customer.call_reporting_setting.call_reporting_enabled";
        public static final String conversionTrackingSettingAcceptedCustomerDataTerms = "customer.conversion_tracking_setting.accepted_customer_data_terms";
        public static final String conversionTrackingSettingConversionTrackingId = "customer.conversion_tracking_setting.conversion_tracking_id";
        public static final String conversionTrackingSettingConversionTrackingStatus = "customer.conversion_tracking_setting.conversion_tracking_status";
        public static final String conversionTrackingSettingCrossAccountConversionTrackingId = "customer.conversion_tracking_setting.cross_account_conversion_tracking_id";
        public static final String conversionTrackingSettingEnhancedConversionsForLeadsEnabled = "customer.conversion_tracking_setting.enhanced_conversions_for_leads_enabled";
        public static final String conversionTrackingSettingGoogleAdsConversionCustomer = "customer.conversion_tracking_setting.google_ads_conversion_customer";
        public static final String currencyCode = "customer.currency_code";
        public static final String customerAgreementSettingAcceptedLeadFormTerms = "customer.customer_agreement_setting.accepted_lead_form_terms";
        public static final String descriptiveName = "customer.descriptive_name";
        public static final String finalUrlSuffix = "customer.final_url_suffix";
        public static final String hasPartnersBadge = "customer.has_partners_badge";
        public static final String id = "customer.id";
        public static final String imageAssetAutoMigrationDone = "customer.image_asset_auto_migration_done";
        public static final String imageAssetAutoMigrationDoneDateTime = "customer.image_asset_auto_migration_done_date_time";
        public static final String localServicesSettingsGranularInsuranceStatuses = "customer.local_services_settings.granular_insurance_statuses";
        public static final String localServicesSettingsGranularLicenseStatuses = "customer.local_services_settings.granular_license_statuses";
        public static final String locationAssetAutoMigrationDone = "customer.location_asset_auto_migration_done";
        public static final String locationAssetAutoMigrationDoneDateTime = "customer.location_asset_auto_migration_done_date_time";
        public static final String manager = "customer.manager";
        public static final String optimizationScore = "customer.optimization_score";
        public static final String optimizationScoreWeight = "customer.optimization_score_weight";
        public static final String payPerConversionEligibilityFailureReasons = "customer.pay_per_conversion_eligibility_failure_reasons";
        public static final String remarketingSettingGoogleGlobalSiteTag = "customer.remarketing_setting.google_global_site_tag";
        public static final String resourceName = "customer.resource_name";
        public static final String status = "customer.status";
        public static final String testAccount = "customer.test_account";
        public static final String timeZone = "customer.time_zone";
        public static final String trackingUrlTemplate = "customer.tracking_url_template";
        public static final String videoBrandSafetySuitability = "customer.video_brand_safety_suitability";
    }

    public static class CustomerAsset {
        public static final String asset = "customer_asset.asset";
        public static final String fieldType = "customer_asset.field_type";
        public static final String primaryStatus = "customer_asset.primary_status";
        public static final String primaryStatusDetails = "customer_asset.primary_status_details";
        public static final String primaryStatusReasons = "customer_asset.primary_status_reasons";
        public static final String resourceName = "customer_asset.resource_name";
        public static final String source = "customer_asset.source";
        public static final String status = "customer_asset.status";
    }

    public static class CustomerAssetSet {
        public static final String assetSet = "customer_asset_set.asset_set";
        public static final String customer = "customer_asset_set.customer";
        public static final String resourceName = "customer_asset_set.resource_name";
        public static final String status = "customer_asset_set.status";
    }

    public static class CustomerClient {
        public static final String appliedLabels = "customer_client.applied_labels";
        public static final String clientCustomer = "customer_client.client_customer";
        public static final String currencyCode = "customer_client.currency_code";
        public static final String descriptiveName = "customer_client.descriptive_name";
        public static final String hidden = "customer_client.hidden";
        public static final String id = "customer_client.id";
        public static final String level = "customer_client.level";
        public static final String manager = "customer_client.manager";
        public static final String resourceName = "customer_client.resource_name";
        public static final String status = "customer_client.status";
        public static final String testAccount = "customer_client.test_account";
        public static final String timeZone = "customer_client.time_zone";
    }

    public static class CustomerClientLink {
        public static final String clientCustomer = "customer_client_link.client_customer";
        public static final String hidden = "customer_client_link.hidden";
        public static final String managerLinkId = "customer_client_link.manager_link_id";
        public static final String resourceName = "customer_client_link.resource_name";
        public static final String status = "customer_client_link.status";
    }

    public static class CustomerConversionGoal {
        public static final String biddable = "customer_conversion_goal.biddable";
        public static final String category = "customer_conversion_goal.category";
        public static final String origin = "customer_conversion_goal.origin";
        public static final String resourceName = "customer_conversion_goal.resource_name";
    }

    public static class CustomerCustomizer {
        public static final String customizerAttribute = "customer_customizer.customizer_attribute";
        public static final String resourceName = "customer_customizer.resource_name";
        public static final String status = "customer_customizer.status";
        public static final String valueStringValue = "customer_customizer.value.string_value";
        public static final String valueType = "customer_customizer.value.type";
    }

    public static class CustomerExtensionSetting {
        public static final String device = "customer_extension_setting.device";
        public static final String extensionFeedItems = "customer_extension_setting.extension_feed_items";
        public static final String extensionType = "customer_extension_setting.extension_type";
        public static final String resourceName = "customer_extension_setting.resource_name";
    }

    public static class CustomerFeed {
        public static final String feed = "customer_feed.feed";
        public static final String matchingFunctionFunctionString = "customer_feed.matching_function.function_string";
        public static final String matchingFunctionLeftOperands = "customer_feed.matching_function.left_operands";
        public static final String matchingFunctionOperator = "customer_feed.matching_function.operator";
        public static final String matchingFunctionRightOperands = "customer_feed.matching_function.right_operands";
        public static final String placeholderTypes = "customer_feed.placeholder_types";
        public static final String resourceName = "customer_feed.resource_name";
        public static final String status = "customer_feed.status";
    }

    public static class CustomerLabel {
        public static final String customer = "customer_label.customer";
        public static final String label = "customer_label.label";
        public static final String resourceName = "customer_label.resource_name";
    }

    public static class CustomerLifecycleGoal {
        public static final String customerAcquisitionGoalValueSettingsHighLifetimeValue = "customer_lifecycle_goal.customer_acquisition_goal_value_settings.high_lifetime_value";
        public static final String customerAcquisitionGoalValueSettingsValue = "customer_lifecycle_goal.customer_acquisition_goal_value_settings.value";
        public static final String lifecycleGoalCustomerDefinitionSettingsExistingUserLists = "customer_lifecycle_goal.lifecycle_goal_customer_definition_settings.existing_user_lists";
        public static final String lifecycleGoalCustomerDefinitionSettingsHighLifetimeValueUserLists = "customer_lifecycle_goal.lifecycle_goal_customer_definition_settings.high_lifetime_value_user_lists";
        public static final String resourceName = "customer_lifecycle_goal.resource_name";
    }

    public static class CustomerManagerLink {
        public static final String managerCustomer = "customer_manager_link.manager_customer";
        public static final String managerLinkId = "customer_manager_link.manager_link_id";
        public static final String resourceName = "customer_manager_link.resource_name";
        public static final String status = "customer_manager_link.status";
    }

    public static class CustomerNegativeCriterion {
        public static final String contentLabelType = "customer_negative_criterion.content_label.type";
        public static final String id = "customer_negative_criterion.id";
        public static final String ipBlockIpAddress = "customer_negative_criterion.ip_block.ip_address";
        public static final String mobileAppCategoryMobileAppCategoryConstant = "customer_negative_criterion.mobile_app_category.mobile_app_category_constant";
        public static final String mobileApplicationAppId = "customer_negative_criterion.mobile_application.app_id";
        public static final String mobileApplicationName = "customer_negative_criterion.mobile_application.name";
        public static final String negativeKeywordListSharedSet = "customer_negative_criterion.negative_keyword_list.shared_set";
        public static final String placementUrl = "customer_negative_criterion.placement.url";
        public static final String resourceName = "customer_negative_criterion.resource_name";
        public static final String type = "customer_negative_criterion.type";
        public static final String youtubeChannelChannelId = "customer_negative_criterion.youtube_channel.channel_id";
        public static final String youtubeVideoVideoId = "customer_negative_criterion.youtube_video.video_id";
    }

    public static class CustomerSearchTermInsight {
        public static final String categoryLabel = "customer_search_term_insight.category_label";
        public static final String id = "customer_search_term_insight.id";
        public static final String resourceName = "customer_search_term_insight.resource_name";
    }

    public static class CustomerUserAccess {
        public static final String accessCreationDateTime = "customer_user_access.access_creation_date_time";
        public static final String accessRole = "customer_user_access.access_role";
        public static final String emailAddress = "customer_user_access.email_address";
        public static final String inviterUserEmailAddress = "customer_user_access.inviter_user_email_address";
        public static final String resourceName = "customer_user_access.resource_name";
        public static final String userId = "customer_user_access.user_id";
    }

    public static class CustomerUserAccessInvitation {
        public static final String accessRole = "customer_user_access_invitation.access_role";
        public static final String creationDateTime = "customer_user_access_invitation.creation_date_time";
        public static final String emailAddress = "customer_user_access_invitation.email_address";
        public static final String invitationId = "customer_user_access_invitation.invitation_id";
        public static final String invitationStatus = "customer_user_access_invitation.invitation_status";
        public static final String resourceName = "customer_user_access_invitation.resource_name";
    }

    public static class CustomizerAttribute {
        public static final String id = "customizer_attribute.id";
        public static final String name = "customizer_attribute.name";
        public static final String resourceName = "customizer_attribute.resource_name";
        public static final String status = "customizer_attribute.status";
        public static final String type = "customizer_attribute.type";
    }

    public static class DetailPlacementView {
        public static final String displayName = "detail_placement_view.display_name";
        public static final String groupPlacementTargetUrl = "detail_placement_view.group_placement_target_url";
        public static final String placement = "detail_placement_view.placement";
        public static final String placementType = "detail_placement_view.placement_type";
        public static final String resourceName = "detail_placement_view.resource_name";
        public static final String targetUrl = "detail_placement_view.target_url";
    }

    public static class DetailedDemographic {
        public static final String availabilities = "detailed_demographic.availabilities";
        public static final String id = "detailed_demographic.id";
        public static final String launchedToAll = "detailed_demographic.launched_to_all";
        public static final String name = "detailed_demographic.name";
        public static final String parent = "detailed_demographic.parent";
        public static final String resourceName = "detailed_demographic.resource_name";
    }

    public static class DisplayKeywordView {
        public static final String resourceName = "display_keyword_view.resource_name";
    }

    public static class DistanceView {
        public static final String distanceBucket = "distance_view.distance_bucket";
        public static final String metricSystem = "distance_view.metric_system";
        public static final String resourceName = "distance_view.resource_name";
    }

    public static class DomainCategory {
        public static final String campaign = "domain_category.campaign";
        public static final String category = "domain_category.category";
        public static final String categoryRank = "domain_category.category_rank";
        public static final String coverageFraction = "domain_category.coverage_fraction";
        public static final String domain = "domain_category.domain";
        public static final String hasChildren = "domain_category.has_children";
        public static final String languageCode = "domain_category.language_code";
        public static final String recommendedCpcBidMicros = "domain_category.recommended_cpc_bid_micros";
        public static final String resourceName = "domain_category.resource_name";
    }

    public static class DynamicSearchAdsSearchTermView {
        public static final String hasMatchingKeyword = "dynamic_search_ads_search_term_view.has_matching_keyword";
        public static final String hasNegativeKeyword = "dynamic_search_ads_search_term_view.has_negative_keyword";
        public static final String hasNegativeUrl = "dynamic_search_ads_search_term_view.has_negative_url";
        public static final String headline = "dynamic_search_ads_search_term_view.headline";
        public static final String landingPage = "dynamic_search_ads_search_term_view.landing_page";
        public static final String pageUrl = "dynamic_search_ads_search_term_view.page_url";
        public static final String resourceName = "dynamic_search_ads_search_term_view.resource_name";
        public static final String searchTerm = "dynamic_search_ads_search_term_view.search_term";
    }

    public static class ExpandedLandingPageView {
        public static final String expandedFinalUrl = "expanded_landing_page_view.expanded_final_url";
        public static final String resourceName = "expanded_landing_page_view.resource_name";
    }

    public static class Experiment {
        public static final String description = "experiment.description";
        public static final String endDate = "experiment.end_date";
        public static final String experimentId = "experiment.experiment_id";
        public static final String goals = "experiment.goals";
        public static final String longRunningOperation = "experiment.long_running_operation";
        public static final String name = "experiment.name";
        public static final String promoteStatus = "experiment.promote_status";
        public static final String resourceName = "experiment.resource_name";
        public static final String startDate = "experiment.start_date";
        public static final String status = "experiment.status";
        public static final String suffix = "experiment.suffix";
        public static final String syncEnabled = "experiment.sync_enabled";
        public static final String type = "experiment.type";
    }

    public static class ExperimentArm {
        public static final String campaigns = "experiment_arm.campaigns";
        public static final String control = "experiment_arm.control";
        public static final String experiment = "experiment_arm.experiment";
        public static final String inDesignCampaigns = "experiment_arm.in_design_campaigns";
        public static final String name = "experiment_arm.name";
        public static final String resourceName = "experiment_arm.resource_name";
        public static final String trafficSplit = "experiment_arm.traffic_split";
    }

    public static class ExtensionFeedItem {
        public static final String adSchedules = "extension_feed_item.ad_schedules";
        public static final String affiliateLocationFeedItemAddressLine1 = "extension_feed_item.affiliate_location_feed_item.address_line_1";
        public static final String affiliateLocationFeedItemAddressLine2 = "extension_feed_item.affiliate_location_feed_item.address_line_2";
        public static final String affiliateLocationFeedItemBusinessName = "extension_feed_item.affiliate_location_feed_item.business_name";
        public static final String affiliateLocationFeedItemChainId = "extension_feed_item.affiliate_location_feed_item.chain_id";
        public static final String affiliateLocationFeedItemChainName = "extension_feed_item.affiliate_location_feed_item.chain_name";
        public static final String affiliateLocationFeedItemCity = "extension_feed_item.affiliate_location_feed_item.city";
        public static final String affiliateLocationFeedItemCountryCode = "extension_feed_item.affiliate_location_feed_item.country_code";
        public static final String affiliateLocationFeedItemPhoneNumber = "extension_feed_item.affiliate_location_feed_item.phone_number";
        public static final String affiliateLocationFeedItemPostalCode = "extension_feed_item.affiliate_location_feed_item.postal_code";
        public static final String affiliateLocationFeedItemProvince = "extension_feed_item.affiliate_location_feed_item.province";
        public static final String appFeedItemAppId = "extension_feed_item.app_feed_item.app_id";
        public static final String appFeedItemAppStore = "extension_feed_item.app_feed_item.app_store";
        public static final String appFeedItemFinalMobileUrls = "extension_feed_item.app_feed_item.final_mobile_urls";
        public static final String appFeedItemFinalUrlSuffix = "extension_feed_item.app_feed_item.final_url_suffix";
        public static final String appFeedItemFinalUrls = "extension_feed_item.app_feed_item.final_urls";
        public static final String appFeedItemLinkText = "extension_feed_item.app_feed_item.link_text";
        public static final String appFeedItemTrackingUrlTemplate = "extension_feed_item.app_feed_item.tracking_url_template";
        public static final String callFeedItemCallConversionAction = "extension_feed_item.call_feed_item.call_conversion_action";
        public static final String callFeedItemCallConversionReportingState = "extension_feed_item.call_feed_item.call_conversion_reporting_state";
        public static final String callFeedItemCallConversionTrackingDisabled = "extension_feed_item.call_feed_item.call_conversion_tracking_disabled";
        public static final String callFeedItemCallTrackingEnabled = "extension_feed_item.call_feed_item.call_tracking_enabled";
        public static final String callFeedItemCountryCode = "extension_feed_item.call_feed_item.country_code";
        public static final String callFeedItemPhoneNumber = "extension_feed_item.call_feed_item.phone_number";
        public static final String calloutFeedItemCalloutText = "extension_feed_item.callout_feed_item.callout_text";
        public static final String device = "extension_feed_item.device";
        public static final String endDateTime = "extension_feed_item.end_date_time";
        public static final String extensionType = "extension_feed_item.extension_type";
        public static final String hotelCalloutFeedItemLanguageCode = "extension_feed_item.hotel_callout_feed_item.language_code";
        public static final String hotelCalloutFeedItemText = "extension_feed_item.hotel_callout_feed_item.text";
        public static final String id = "extension_feed_item.id";
        public static final String imageFeedItemImageAsset = "extension_feed_item.image_feed_item.image_asset";
        public static final String locationFeedItemAddressLine1 = "extension_feed_item.location_feed_item.address_line_1";
        public static final String locationFeedItemAddressLine2 = "extension_feed_item.location_feed_item.address_line_2";
        public static final String locationFeedItemBusinessName = "extension_feed_item.location_feed_item.business_name";
        public static final String locationFeedItemCity = "extension_feed_item.location_feed_item.city";
        public static final String locationFeedItemCountryCode = "extension_feed_item.location_feed_item.country_code";
        public static final String locationFeedItemPhoneNumber = "extension_feed_item.location_feed_item.phone_number";
        public static final String locationFeedItemPostalCode = "extension_feed_item.location_feed_item.postal_code";
        public static final String locationFeedItemProvince = "extension_feed_item.location_feed_item.province";
        public static final String priceFeedItemFinalUrlSuffix = "extension_feed_item.price_feed_item.final_url_suffix";
        public static final String priceFeedItemLanguageCode = "extension_feed_item.price_feed_item.language_code";
        public static final String priceFeedItemPriceOfferings = "extension_feed_item.price_feed_item.price_offerings";
        public static final String priceFeedItemPriceQualifier = "extension_feed_item.price_feed_item.price_qualifier";
        public static final String priceFeedItemTrackingUrlTemplate = "extension_feed_item.price_feed_item.tracking_url_template";
        public static final String priceFeedItemType = "extension_feed_item.price_feed_item.type";
        public static final String promotionFeedItemDiscountModifier = "extension_feed_item.promotion_feed_item.discount_modifier";
        public static final String promotionFeedItemFinalMobileUrls = "extension_feed_item.promotion_feed_item.final_mobile_urls";
        public static final String promotionFeedItemFinalUrlSuffix = "extension_feed_item.promotion_feed_item.final_url_suffix";
        public static final String promotionFeedItemFinalUrls = "extension_feed_item.promotion_feed_item.final_urls";
        public static final String promotionFeedItemLanguageCode = "extension_feed_item.promotion_feed_item.language_code";
        public static final String promotionFeedItemMoneyAmountOffAmountMicros = "extension_feed_item.promotion_feed_item.money_amount_off.amount_micros";
        public static final String promotionFeedItemMoneyAmountOffCurrencyCode = "extension_feed_item.promotion_feed_item.money_amount_off.currency_code";
        public static final String promotionFeedItemOccasion = "extension_feed_item.promotion_feed_item.occasion";
        public static final String promotionFeedItemOrdersOverAmountAmountMicros = "extension_feed_item.promotion_feed_item.orders_over_amount.amount_micros";
        public static final String promotionFeedItemOrdersOverAmountCurrencyCode = "extension_feed_item.promotion_feed_item.orders_over_amount.currency_code";
        public static final String promotionFeedItemPercentOff = "extension_feed_item.promotion_feed_item.percent_off";
        public static final String promotionFeedItemPromotionCode = "extension_feed_item.promotion_feed_item.promotion_code";
        public static final String promotionFeedItemPromotionEndDate = "extension_feed_item.promotion_feed_item.promotion_end_date";
        public static final String promotionFeedItemPromotionStartDate = "extension_feed_item.promotion_feed_item.promotion_start_date";
        public static final String promotionFeedItemPromotionTarget = "extension_feed_item.promotion_feed_item.promotion_target";
        public static final String promotionFeedItemTrackingUrlTemplate = "extension_feed_item.promotion_feed_item.tracking_url_template";
        public static final String resourceName = "extension_feed_item.resource_name";
        public static final String sitelinkFeedItemFinalMobileUrls = "extension_feed_item.sitelink_feed_item.final_mobile_urls";
        public static final String sitelinkFeedItemFinalUrlSuffix = "extension_feed_item.sitelink_feed_item.final_url_suffix";
        public static final String sitelinkFeedItemFinalUrls = "extension_feed_item.sitelink_feed_item.final_urls";
        public static final String sitelinkFeedItemLine1 = "extension_feed_item.sitelink_feed_item.line1";
        public static final String sitelinkFeedItemLine2 = "extension_feed_item.sitelink_feed_item.line2";
        public static final String sitelinkFeedItemLinkText = "extension_feed_item.sitelink_feed_item.link_text";
        public static final String sitelinkFeedItemTrackingUrlTemplate = "extension_feed_item.sitelink_feed_item.tracking_url_template";
        public static final String startDateTime = "extension_feed_item.start_date_time";
        public static final String status = "extension_feed_item.status";
        public static final String structuredSnippetFeedItemHeader = "extension_feed_item.structured_snippet_feed_item.header";
        public static final String structuredSnippetFeedItemValues = "extension_feed_item.structured_snippet_feed_item.values";
        public static final String targetedAdGroup = "extension_feed_item.targeted_ad_group";
        public static final String targetedCampaign = "extension_feed_item.targeted_campaign";
        public static final String targetedGeoTargetConstant = "extension_feed_item.targeted_geo_target_constant";
        public static final String targetedKeywordMatchType = "extension_feed_item.targeted_keyword.match_type";
        public static final String targetedKeywordText = "extension_feed_item.targeted_keyword.text";
        public static final String textMessageFeedItemBusinessName = "extension_feed_item.text_message_feed_item.business_name";
        public static final String textMessageFeedItemCountryCode = "extension_feed_item.text_message_feed_item.country_code";
        public static final String textMessageFeedItemExtensionText = "extension_feed_item.text_message_feed_item.extension_text";
        public static final String textMessageFeedItemPhoneNumber = "extension_feed_item.text_message_feed_item.phone_number";
        public static final String textMessageFeedItemText = "extension_feed_item.text_message_feed_item.text";
    }

    public static class Feed {
        public static final String affiliateLocationFeedDataChainIds = "feed.affiliate_location_feed_data.chain_ids";
        public static final String affiliateLocationFeedDataRelationshipType = "feed.affiliate_location_feed_data.relationship_type";
        public static final String attributes = "feed.attributes";
        public static final String id = "feed.id";
        public static final String name = "feed.name";
        public static final String origin = "feed.origin";
        public static final String placesLocationFeedDataBusinessNameFilter = "feed.places_location_feed_data.business_name_filter";
        public static final String placesLocationFeedDataCategoryFilters = "feed.places_location_feed_data.category_filters";
        public static final String placesLocationFeedDataEmailAddress = "feed.places_location_feed_data.email_address";
        public static final String placesLocationFeedDataLabelFilters = "feed.places_location_feed_data.label_filters";
        public static final String resourceName = "feed.resource_name";
        public static final String status = "feed.status";
    }

    public static class FeedItem {
        public static final String attributeValues = "feed_item.attribute_values";
        public static final String endDateTime = "feed_item.end_date_time";
        public static final String feed = "feed_item.feed";
        public static final String geoTargetingRestriction = "feed_item.geo_targeting_restriction";
        public static final String id = "feed_item.id";
        public static final String policyInfos = "feed_item.policy_infos";
        public static final String resourceName = "feed_item.resource_name";
        public static final String startDateTime = "feed_item.start_date_time";
        public static final String status = "feed_item.status";
        public static final String urlCustomParameters = "feed_item.url_custom_parameters";
    }

    public static class FeedItemSet {
        public static final String displayName = "feed_item_set.display_name";
        public static final String dynamicAffiliateLocationSetFilterChainIds = "feed_item_set.dynamic_affiliate_location_set_filter.chain_ids";
        public static final String dynamicLocationSetFilterBusinessNameFilterBusinessName = "feed_item_set.dynamic_location_set_filter.business_name_filter.business_name";
        public static final String dynamicLocationSetFilterBusinessNameFilterFilterType = "feed_item_set.dynamic_location_set_filter.business_name_filter.filter_type";
        public static final String dynamicLocationSetFilterLabels = "feed_item_set.dynamic_location_set_filter.labels";
        public static final String feed = "feed_item_set.feed";
        public static final String feedItemSetId = "feed_item_set.feed_item_set_id";
        public static final String resourceName = "feed_item_set.resource_name";
        public static final String status = "feed_item_set.status";
    }

    public static class FeedItemSetLink {
        public static final String feedItem = "feed_item_set_link.feed_item";
        public static final String feedItemSet = "feed_item_set_link.feed_item_set";
        public static final String resourceName = "feed_item_set_link.resource_name";
    }

    public static class FeedItemTarget {
        public static final String adGroup = "feed_item_target.ad_group";
        public static final String adSchedule = "feed_item_target.ad_schedule";
        public static final String adScheduleDayOfWeek = "feed_item_target.ad_schedule.day_of_week";
        public static final String campaign = "feed_item_target.campaign";
        public static final String device = "feed_item_target.device";
        public static final String feedItem = "feed_item_target.feed_item";
        public static final String feedItemTargetId = "feed_item_target.feed_item_target_id";
        public static final String feedItemTargetType = "feed_item_target.feed_item_target_type";
        public static final String geoTargetConstant = "feed_item_target.geo_target_constant";
        public static final String keywordMatchType = "feed_item_target.keyword.match_type";
        public static final String keywordText = "feed_item_target.keyword.text";
        public static final String resourceName = "feed_item_target.resource_name";
        public static final String status = "feed_item_target.status";
    }

    public static class FeedMapping {
        public static final String attributeFieldMappings = "feed_mapping.attribute_field_mappings";
        public static final String criterionType = "feed_mapping.criterion_type";
        public static final String feed = "feed_mapping.feed";
        public static final String placeholderType = "feed_mapping.placeholder_type";
        public static final String resourceName = "feed_mapping.resource_name";
        public static final String status = "feed_mapping.status";
    }

    public static class FeedPlaceholderView {
        public static final String placeholderType = "feed_placeholder_view.placeholder_type";
        public static final String resourceName = "feed_placeholder_view.resource_name";
    }

    public static class GenderView {
        public static final String resourceName = "gender_view.resource_name";
    }

    public static class GeoTargetConstant {
        public static final String canonicalName = "geo_target_constant.canonical_name";
        public static final String countryCode = "geo_target_constant.country_code";
        public static final String id = "geo_target_constant.id";
        public static final String name = "geo_target_constant.name";
        public static final String parentGeoTarget = "geo_target_constant.parent_geo_target";
        public static final String resourceName = "geo_target_constant.resource_name";
        public static final String status = "geo_target_constant.status";
        public static final String targetType = "geo_target_constant.target_type";
    }

    public static class GeographicView {
        public static final String countryCriterionId = "geographic_view.country_criterion_id";
        public static final String locationType = "geographic_view.location_type";
        public static final String resourceName = "geographic_view.resource_name";
    }

    public static class GroupPlacementView {
        public static final String displayName = "group_placement_view.display_name";
        public static final String placement = "group_placement_view.placement";
        public static final String placementType = "group_placement_view.placement_type";
        public static final String resourceName = "group_placement_view.resource_name";
        public static final String targetUrl = "group_placement_view.target_url";
    }

    public static class HotelGroupView {
        public static final String resourceName = "hotel_group_view.resource_name";
    }

    public static class HotelPerformanceView {
        public static final String resourceName = "hotel_performance_view.resource_name";
    }

    public static class HotelReconciliation {
        public static final String billed = "hotel_reconciliation.billed";
        public static final String campaign = "hotel_reconciliation.campaign";
        public static final String checkInDate = "hotel_reconciliation.check_in_date";
        public static final String checkOutDate = "hotel_reconciliation.check_out_date";
        public static final String commissionId = "hotel_reconciliation.commission_id";
        public static final String hotelCenterId = "hotel_reconciliation.hotel_center_id";
        public static final String hotelId = "hotel_reconciliation.hotel_id";
        public static final String orderId = "hotel_reconciliation.order_id";
        public static final String reconciledValueMicros = "hotel_reconciliation.reconciled_value_micros";
        public static final String resourceName = "hotel_reconciliation.resource_name";
        public static final String status = "hotel_reconciliation.status";
    }

    public static class IncomeRangeView {
        public static final String resourceName = "income_range_view.resource_name";
    }

    public static class KeywordPlan {
        public static final String forecastPeriod = "keyword_plan.forecast_period";
        public static final String id = "keyword_plan.id";
        public static final String name = "keyword_plan.name";
        public static final String resourceName = "keyword_plan.resource_name";
    }

    public static class KeywordPlanAdGroup {
        public static final String cpcBidMicros = "keyword_plan_ad_group.cpc_bid_micros";
        public static final String id = "keyword_plan_ad_group.id";
        public static final String keywordPlanCampaign = "keyword_plan_ad_group.keyword_plan_campaign";
        public static final String name = "keyword_plan_ad_group.name";
        public static final String resourceName = "keyword_plan_ad_group.resource_name";
    }

    public static class KeywordPlanAdGroupKeyword {
        public static final String cpcBidMicros = "keyword_plan_ad_group_keyword.cpc_bid_micros";
        public static final String id = "keyword_plan_ad_group_keyword.id";
        public static final String keywordPlanAdGroup = "keyword_plan_ad_group_keyword.keyword_plan_ad_group";
        public static final String matchType = "keyword_plan_ad_group_keyword.match_type";
        public static final String negative = "keyword_plan_ad_group_keyword.negative";
        public static final String resourceName = "keyword_plan_ad_group_keyword.resource_name";
        public static final String text = "keyword_plan_ad_group_keyword.text";
    }

    public static class KeywordPlanCampaign {
        public static final String cpcBidMicros = "keyword_plan_campaign.cpc_bid_micros";
        public static final String geoTargets = "keyword_plan_campaign.geo_targets";
        public static final String geoTargetsGeoTargetConstant = "keyword_plan_campaign.geo_targets.geo_target_constant";
        public static final String id = "keyword_plan_campaign.id";
        public static final String keywordPlan = "keyword_plan_campaign.keyword_plan";
        public static final String keywordPlanNetwork = "keyword_plan_campaign.keyword_plan_network";
        public static final String languageConstants = "keyword_plan_campaign.language_constants";
        public static final String name = "keyword_plan_campaign.name";
        public static final String resourceName = "keyword_plan_campaign.resource_name";
    }

    public static class KeywordPlanCampaignKeyword {
        public static final String id = "keyword_plan_campaign_keyword.id";
        public static final String keywordPlanCampaign = "keyword_plan_campaign_keyword.keyword_plan_campaign";
        public static final String matchType = "keyword_plan_campaign_keyword.match_type";
        public static final String negative = "keyword_plan_campaign_keyword.negative";
        public static final String resourceName = "keyword_plan_campaign_keyword.resource_name";
        public static final String text = "keyword_plan_campaign_keyword.text";
    }

    public static class KeywordThemeConstant {
        public static final String countryCode = "keyword_theme_constant.country_code";
        public static final String displayName = "keyword_theme_constant.display_name";
        public static final String languageCode = "keyword_theme_constant.language_code";
        public static final String resourceName = "keyword_theme_constant.resource_name";
    }

    public static class KeywordView {
        public static final String resourceName = "keyword_view.resource_name";
    }

    public static class Label {
        public static final String id = "label.id";
        public static final String name = "label.name";
        public static final String resourceName = "label.resource_name";
        public static final String status = "label.status";
        public static final String textLabelBackgroundColor = "label.text_label.background_color";
        public static final String textLabelDescription = "label.text_label.description";
    }

    public static class LandingPageView {
        public static final String resourceName = "landing_page_view.resource_name";
        public static final String unexpandedFinalUrl = "landing_page_view.unexpanded_final_url";
    }

    public static class LanguageConstant {
        public static final String code = "language_constant.code";
        public static final String id = "language_constant.id";
        public static final String name = "language_constant.name";
        public static final String resourceName = "language_constant.resource_name";
        public static final String targetable = "language_constant.targetable";
    }

    public static class LeadFormSubmissionData {
        public static final String adGroup = "lead_form_submission_data.ad_group";
        public static final String adGroupAd = "lead_form_submission_data.ad_group_ad";
        public static final String asset = "lead_form_submission_data.asset";
        public static final String campaign = "lead_form_submission_data.campaign";
        public static final String customLeadFormSubmissionFields = "lead_form_submission_data.custom_lead_form_submission_fields";
        public static final String gclid = "lead_form_submission_data.gclid";
        public static final String id = "lead_form_submission_data.id";
        public static final String leadFormSubmissionFields = "lead_form_submission_data.lead_form_submission_fields";
        public static final String resourceName = "lead_form_submission_data.resource_name";
        public static final String submissionDateTime = "lead_form_submission_data.submission_date_time";
    }

    public static class LifeEvent {
        public static final String availabilities = "life_event.availabilities";
        public static final String id = "life_event.id";
        public static final String launchedToAll = "life_event.launched_to_all";
        public static final String name = "life_event.name";
        public static final String parent = "life_event.parent";
        public static final String resourceName = "life_event.resource_name";
    }

    public static class LocalServicesEmployee {
        public static final String categoryIds = "local_services_employee.category_ids";
        public static final String creationDateTime = "local_services_employee.creation_date_time";
        public static final String emailAddress = "local_services_employee.email_address";
        public static final String fellowships = "local_services_employee.fellowships";
        public static final String firstName = "local_services_employee.first_name";
        public static final String id = "local_services_employee.id";
        public static final String jobTitle = "local_services_employee.job_title";
        public static final String languagesSpoken = "local_services_employee.languages_spoken";
        public static final String lastName = "local_services_employee.last_name";
        public static final String middleName = "local_services_employee.middle_name";
        public static final String nationalProviderIdNumber = "local_services_employee.national_provider_id_number";
        public static final String residencies = "local_services_employee.residencies";
        public static final String resourceName = "local_services_employee.resource_name";
        public static final String status = "local_services_employee.status";
        public static final String type = "local_services_employee.type";
        public static final String universityDegrees = "local_services_employee.university_degrees";
        public static final String yearStartedPracticing = "local_services_employee.year_started_practicing";
    }

    public static class LocalServicesLead {
        public static final String categoryId = "local_services_lead.category_id";
        public static final String contactDetails = "local_services_lead.contact_details";
        public static final String creationDateTime = "local_services_lead.creation_date_time";
        public static final String creditDetailsCreditState = "local_services_lead.credit_details.credit_state";
        public static final String creditDetailsCreditStateLastUpdateDateTime = "local_services_lead.credit_details.credit_state_last_update_date_time";
        public static final String id = "local_services_lead.id";
        public static final String leadCharged = "local_services_lead.lead_charged";
        public static final String leadStatus = "local_services_lead.lead_status";
        public static final String leadType = "local_services_lead.lead_type";
        public static final String locale = "local_services_lead.locale";
        public static final String noteDescription = "local_services_lead.note.description";
        public static final String noteEditDateTime = "local_services_lead.note.edit_date_time";
        public static final String resourceName = "local_services_lead.resource_name";
        public static final String serviceId = "local_services_lead.service_id";
    }

    public static class LocalServicesLeadConversation {
        public static final String conversationChannel = "local_services_lead_conversation.conversation_channel";
        public static final String eventDateTime = "local_services_lead_conversation.event_date_time";
        public static final String id = "local_services_lead_conversation.id";
        public static final String lead = "local_services_lead_conversation.lead";
        public static final String messageDetailsAttachmentUrls = "local_services_lead_conversation.message_details.attachment_urls";
        public static final String messageDetailsText = "local_services_lead_conversation.message_details.text";
        public static final String participantType = "local_services_lead_conversation.participant_type";
        public static final String phoneCallDetailsCallDurationMillis = "local_services_lead_conversation.phone_call_details.call_duration_millis";
        public static final String phoneCallDetailsCallRecordingUrl = "local_services_lead_conversation.phone_call_details.call_recording_url";
        public static final String resourceName = "local_services_lead_conversation.resource_name";
    }

    public static class LocalServicesVerificationArtifact {
        public static final String artifactType = "local_services_verification_artifact.artifact_type";
        public static final String backgroundCheckVerificationArtifactCaseUrl = "local_services_verification_artifact.background_check_verification_artifact.case_url";
        public static final String backgroundCheckVerificationArtifactFinalAdjudicationDateTime = "local_services_verification_artifact.background_check_verification_artifact.final_adjudication_date_time";
        public static final String businessRegistrationCheckVerificationArtifactCheckId = "local_services_verification_artifact.business_registration_check_verification_artifact.check_id";
        public static final String businessRegistrationCheckVerificationArtifactRegistrationDocumentDocumentReadonlyDocumentUrl = "local_services_verification_artifact.business_registration_check_verification_artifact.registration_document.document_readonly.document_url";
        public static final String businessRegistrationCheckVerificationArtifactRegistrationNumberNumber = "local_services_verification_artifact.business_registration_check_verification_artifact.registration_number.number";
        public static final String businessRegistrationCheckVerificationArtifactRegistrationType = "local_services_verification_artifact.business_registration_check_verification_artifact.registration_type";
        public static final String businessRegistrationCheckVerificationArtifactRejectionReason = "local_services_verification_artifact.business_registration_check_verification_artifact.rejection_reason";
        public static final String creationDateTime = "local_services_verification_artifact.creation_date_time";
        public static final String id = "local_services_verification_artifact.id";
        public static final String insuranceVerificationArtifactAmountMicros = "local_services_verification_artifact.insurance_verification_artifact.amount_micros";
        public static final String insuranceVerificationArtifactInsuranceDocumentReadonlyDocumentUrl = "local_services_verification_artifact.insurance_verification_artifact.insurance_document_readonly.document_url";
        public static final String insuranceVerificationArtifactRejectionReason = "local_services_verification_artifact.insurance_verification_artifact.rejection_reason";
        public static final String licenseVerificationArtifactLicenseDocumentReadonlyDocumentUrl = "local_services_verification_artifact.license_verification_artifact.license_document_readonly.document_url";
        public static final String licenseVerificationArtifactLicenseNumber = "local_services_verification_artifact.license_verification_artifact.license_number";
        public static final String licenseVerificationArtifactLicenseType = "local_services_verification_artifact.license_verification_artifact.license_type";
        public static final String licenseVerificationArtifactLicenseeFirstName = "local_services_verification_artifact.license_verification_artifact.licensee_first_name";
        public static final String licenseVerificationArtifactLicenseeLastName = "local_services_verification_artifact.license_verification_artifact.licensee_last_name";
        public static final String licenseVerificationArtifactRejectionReason = "local_services_verification_artifact.license_verification_artifact.rejection_reason";
        public static final String resourceName = "local_services_verification_artifact.resource_name";
        public static final String status = "local_services_verification_artifact.status";
    }

    public static class LocationView {
        public static final String resourceName = "location_view.resource_name";
    }

    public static class ManagedPlacementView {
        public static final String resourceName = "managed_placement_view.resource_name";
    }

    public static class MediaFile {
        public static final String audioAdDurationMillis = "media_file.audio.ad_duration_millis";
        public static final String fileSize = "media_file.file_size";
        public static final String id = "media_file.id";
        public static final String imageFullSizeImageUrl = "media_file.image.full_size_image_url";
        public static final String imagePreviewSizeImageUrl = "media_file.image.preview_size_image_url";
        public static final String mediaBundleUrl = "media_file.media_bundle.url";
        public static final String mimeType = "media_file.mime_type";
        public static final String name = "media_file.name";
        public static final String resourceName = "media_file.resource_name";
        public static final String sourceUrl = "media_file.source_url";
        public static final String type = "media_file.type";
        public static final String videoAdDurationMillis = "media_file.video.ad_duration_millis";
        public static final String videoAdvertisingIdCode = "media_file.video.advertising_id_code";
        public static final String videoIsciCode = "media_file.video.isci_code";
        public static final String videoYoutubeVideoId = "media_file.video.youtube_video_id";
    }

    public static class MobileAppCategoryConstant {
        public static final String id = "mobile_app_category_constant.id";
        public static final String name = "mobile_app_category_constant.name";
        public static final String resourceName = "mobile_app_category_constant.resource_name";
    }

    public static class MobileDeviceConstant {
        public static final String id = "mobile_device_constant.id";
        public static final String manufacturerName = "mobile_device_constant.manufacturer_name";
        public static final String name = "mobile_device_constant.name";
        public static final String operatingSystemName = "mobile_device_constant.operating_system_name";
        public static final String resourceName = "mobile_device_constant.resource_name";
        public static final String type = "mobile_device_constant.type";
    }

    public static class OfflineConversionUploadClientSummary {
        public static final String alerts = "offline_conversion_upload_client_summary.alerts";
        public static final String client = "offline_conversion_upload_client_summary.client";
        public static final String dailySummaries = "offline_conversion_upload_client_summary.daily_summaries";
        public static final String jobSummaries = "offline_conversion_upload_client_summary.job_summaries";
        public static final String lastUploadDateTime = "offline_conversion_upload_client_summary.last_upload_date_time";
        public static final String resourceName = "offline_conversion_upload_client_summary.resource_name";
        public static final String status = "offline_conversion_upload_client_summary.status";
        public static final String successRate = "offline_conversion_upload_client_summary.success_rate";
        public static final String successfulEventCount = "offline_conversion_upload_client_summary.successful_event_count";
        public static final String totalEventCount = "offline_conversion_upload_client_summary.total_event_count";
    }

    public static class OfflineUserDataJob {
        public static final String customerMatchUserListMetadataUserList = "offline_user_data_job.customer_match_user_list_metadata.user_list";
        public static final String externalId = "offline_user_data_job.external_id";
        public static final String failureReason = "offline_user_data_job.failure_reason";
        public static final String id = "offline_user_data_job.id";
        public static final String operationMetadataMatchRateRange = "offline_user_data_job.operation_metadata.match_rate_range";
        public static final String resourceName = "offline_user_data_job.resource_name";
        public static final String status = "offline_user_data_job.status";
        public static final String storeSalesMetadataLoyaltyFraction = "offline_user_data_job.store_sales_metadata.loyalty_fraction";
        public static final String storeSalesMetadataThirdPartyMetadataAdvertiserUploadDateTime = "offline_user_data_job.store_sales_metadata.third_party_metadata.advertiser_upload_date_time";
        public static final String storeSalesMetadataThirdPartyMetadataBridgeMapVersionId = "offline_user_data_job.store_sales_metadata.third_party_metadata.bridge_map_version_id";
        public static final String storeSalesMetadataThirdPartyMetadataPartnerId = "offline_user_data_job.store_sales_metadata.third_party_metadata.partner_id";
        public static final String storeSalesMetadataThirdPartyMetadataPartnerMatchFraction = "offline_user_data_job.store_sales_metadata.third_party_metadata.partner_match_fraction";
        public static final String storeSalesMetadataThirdPartyMetadataPartnerUploadFraction = "offline_user_data_job.store_sales_metadata.third_party_metadata.partner_upload_fraction";
        public static final String storeSalesMetadataThirdPartyMetadataValidTransactionFraction = "offline_user_data_job.store_sales_metadata.third_party_metadata.valid_transaction_fraction";
        public static final String storeSalesMetadataTransactionUploadFraction = "offline_user_data_job.store_sales_metadata.transaction_upload_fraction";
        public static final String type = "offline_user_data_job.type";
    }

    public static class OperatingSystemVersionConstant {
        public static final String id = "operating_system_version_constant.id";
        public static final String name = "operating_system_version_constant.name";
        public static final String operatorType = "operating_system_version_constant.operator_type";
        public static final String osMajorVersion = "operating_system_version_constant.os_major_version";
        public static final String osMinorVersion = "operating_system_version_constant.os_minor_version";
        public static final String resourceName = "operating_system_version_constant.resource_name";
    }

    public static class PaidOrganicSearchTermView {
        public static final String resourceName = "paid_organic_search_term_view.resource_name";
        public static final String searchTerm = "paid_organic_search_term_view.search_term";
    }

    public static class ParentalStatusView {
        public static final String resourceName = "parental_status_view.resource_name";
    }

    public static class PerStoreView {
        public static final String placeId = "per_store_view.place_id";
        public static final String resourceName = "per_store_view.resource_name";
    }

    public static class ProductCategoryConstant {
        public static final String categoryId = "product_category_constant.category_id";
        public static final String level = "product_category_constant.level";
        public static final String localizations = "product_category_constant.localizations";
        public static final String productCategoryConstantParent = "product_category_constant.product_category_constant_parent";
        public static final String resourceName = "product_category_constant.resource_name";
        public static final String state = "product_category_constant.state";
    }

    public static class ProductGroupView {
        public static final String resourceName = "product_group_view.resource_name";
    }

    public static class ProductLink {
        public static final String advertisingPartnerCustomer = "product_link.advertising_partner.customer";
        public static final String dataPartnerDataPartnerId = "product_link.data_partner.data_partner_id";
        public static final String googleAdsCustomer = "product_link.google_ads.customer";
        public static final String merchantCenterMerchantCenterId = "product_link.merchant_center.merchant_center_id";
        public static final String productLinkId = "product_link.product_link_id";
        public static final String resourceName = "product_link.resource_name";
        public static final String type = "product_link.type";
    }

    public static class ProductLinkInvitation {
        public static final String advertisingPartnerCustomer = "product_link_invitation.advertising_partner.customer";
        public static final String hotelCenterHotelCenterId = "product_link_invitation.hotel_center.hotel_center_id";
        public static final String merchantCenterMerchantCenterId = "product_link_invitation.merchant_center.merchant_center_id";
        public static final String productLinkInvitationId = "product_link_invitation.product_link_invitation_id";
        public static final String resourceName = "product_link_invitation.resource_name";
        public static final String status = "product_link_invitation.status";
        public static final String type = "product_link_invitation.type";
    }

    public static class QualifyingQuestion {
        public static final String locale = "qualifying_question.locale";
        public static final String qualifyingQuestionId = "qualifying_question.qualifying_question_id";
        public static final String resourceName = "qualifying_question.resource_name";
        public static final String text = "qualifying_question.text";
    }

    public static class Recommendation {
        public static final String adGroup = "recommendation.ad_group";
        public static final String callAssetRecommendation = "recommendation.call_asset_recommendation";
        public static final String calloutAssetRecommendation = "recommendation.callout_asset_recommendation";
        public static final String campaign = "recommendation.campaign";
        public static final String campaignBudget = "recommendation.campaign_budget";
        public static final String campaignBudgetRecommendation = "recommendation.campaign_budget_recommendation";
        public static final String campaigns = "recommendation.campaigns";
        public static final String customAudienceOptInRecommendation = "recommendation.custom_audience_opt_in_recommendation";
        public static final String dismissed = "recommendation.dismissed";
        public static final String displayExpansionOptInRecommendation = "recommendation.display_expansion_opt_in_recommendation";
        public static final String dynamicImageExtensionOptInRecommendation = "recommendation.dynamic_image_extension_opt_in_recommendation";
        public static final String enhancedCpcOptInRecommendation = "recommendation.enhanced_cpc_opt_in_recommendation";
        public static final String forecastingCampaignBudgetRecommendation = "recommendation.forecasting_campaign_budget_recommendation";
        public static final String forecastingSetTargetCpaRecommendation = "recommendation.forecasting_set_target_cpa_recommendation";
        public static final String forecastingSetTargetRoasRecommendation = "recommendation.forecasting_set_target_roas_recommendation";
        public static final String impact = "recommendation.impact";
        public static final String improveDemandGenAdStrengthRecommendation = "recommendation.improve_demand_gen_ad_strength_recommendation";
        public static final String improveGoogleTagCoverageRecommendation = "recommendation.improve_google_tag_coverage_recommendation";
        public static final String improvePerformanceMaxAdStrengthRecommendation = "recommendation.improve_performance_max_ad_strength_recommendation";
        public static final String keywordMatchTypeRecommendation = "recommendation.keyword_match_type_recommendation";
        public static final String keywordRecommendation = "recommendation.keyword_recommendation";
        public static final String leadFormAssetRecommendation = "recommendation.lead_form_asset_recommendation";
        public static final String lowerTargetRoasRecommendation = "recommendation.lower_target_roas_recommendation";
        public static final String marginalRoiCampaignBudgetRecommendation = "recommendation.marginal_roi_campaign_budget_recommendation";
        public static final String maximizeClicksOptInRecommendation = "recommendation.maximize_clicks_opt_in_recommendation";
        public static final String maximizeConversionValueOptInRecommendation = "recommendation.maximize_conversion_value_opt_in_recommendation";
        public static final String maximizeConversionsOptInRecommendation = "recommendation.maximize_conversions_opt_in_recommendation";
        public static final String migrateDynamicSearchAdsCampaignToPerformanceMaxRecommendation = "recommendation.migrate_dynamic_search_ads_campaign_to_performance_max_recommendation";
        public static final String moveUnusedBudgetRecommendation = "recommendation.move_unused_budget_recommendation";
        public static final String optimizeAdRotationRecommendation = "recommendation.optimize_ad_rotation_recommendation";
        public static final String performanceMaxFinalUrlOptInRecommendation = "recommendation.performance_max_final_url_opt_in_recommendation";
        public static final String performanceMaxOptInRecommendation = "recommendation.performance_max_opt_in_recommendation";
        public static final String raiseTargetCpaBidTooLowRecommendation = "recommendation.raise_target_cpa_bid_too_low_recommendation";
        public static final String raiseTargetCpaRecommendation = "recommendation.raise_target_cpa_recommendation";
        public static final String refreshCustomerMatchListRecommendation = "recommendation.refresh_customer_match_list_recommendation";
        public static final String resourceName = "recommendation.resource_name";
        public static final String responsiveSearchAdAssetRecommendation = "recommendation.responsive_search_ad_asset_recommendation";
        public static final String responsiveSearchAdImproveAdStrengthRecommendation = "recommendation.responsive_search_ad_improve_ad_strength_recommendation";
        public static final String responsiveSearchAdRecommendation = "recommendation.responsive_search_ad_recommendation";
        public static final String searchPartnersOptInRecommendation = "recommendation.search_partners_opt_in_recommendation";
        public static final String setTargetCpaRecommendation = "recommendation.set_target_cpa_recommendation";
        public static final String setTargetRoasRecommendation = "recommendation.set_target_roas_recommendation";
        public static final String shoppingAddAgeGroupRecommendation = "recommendation.shopping_add_age_group_recommendation";
        public static final String shoppingAddColorRecommendation = "recommendation.shopping_add_color_recommendation";
        public static final String shoppingAddGenderRecommendation = "recommendation.shopping_add_gender_recommendation";
        public static final String shoppingAddGtinRecommendation = "recommendation.shopping_add_gtin_recommendation";
        public static final String shoppingAddMoreIdentifiersRecommendation = "recommendation.shopping_add_more_identifiers_recommendation";
        public static final String shoppingAddProductsToCampaignRecommendation = "recommendation.shopping_add_products_to_campaign_recommendation";
        public static final String shoppingAddSizeRecommendation = "recommendation.shopping_add_size_recommendation";
        public static final String shoppingFixDisapprovedProductsRecommendation = "recommendation.shopping_fix_disapproved_products_recommendation";
        public static final String shoppingFixMerchantCenterAccountSuspensionWarningRecommendation = "recommendation.shopping_fix_merchant_center_account_suspension_warning_recommendation";
        public static final String shoppingFixSuspendedMerchantCenterAccountRecommendation = "recommendation.shopping_fix_suspended_merchant_center_account_recommendation";
        public static final String shoppingMigrateRegularShoppingCampaignOffersToPerformanceMaxRecommendation = "recommendation.shopping_migrate_regular_shopping_campaign_offers_to_performance_max_recommendation";
        public static final String shoppingTargetAllOffersRecommendation = "recommendation.shopping_target_all_offers_recommendation";
        public static final String sitelinkAssetRecommendation = "recommendation.sitelink_asset_recommendation";
        public static final String targetCpaOptInRecommendation = "recommendation.target_cpa_opt_in_recommendation";
        public static final String targetRoasOptInRecommendation = "recommendation.target_roas_opt_in_recommendation";
        public static final String textAdRecommendation = "recommendation.text_ad_recommendation";
        public static final String type = "recommendation.type";
        public static final String upgradeLocalCampaignToPerformanceMaxRecommendation = "recommendation.upgrade_local_campaign_to_performance_max_recommendation";
        public static final String upgradeSmartShoppingCampaignToPerformanceMaxRecommendation = "recommendation.upgrade_smart_shopping_campaign_to_performance_max_recommendation";
        public static final String useBroadMatchKeywordRecommendation = "recommendation.use_broad_match_keyword_recommendation";
    }

    public static class RecommendationSubscription {
        public static final String createDateTime = "recommendation_subscription.create_date_time";
        public static final String modifyDateTime = "recommendation_subscription.modify_date_time";
        public static final String resourceName = "recommendation_subscription.resource_name";
        public static final String status = "recommendation_subscription.status";
        public static final String type = "recommendation_subscription.type";
    }

    public static class RemarketingAction {
        public static final String id = "remarketing_action.id";
        public static final String name = "remarketing_action.name";
        public static final String resourceName = "remarketing_action.resource_name";
        public static final String tagSnippets = "remarketing_action.tag_snippets";
    }

    public static class SearchTermView {
        public static final String adGroup = "search_term_view.ad_group";
        public static final String resourceName = "search_term_view.resource_name";
        public static final String searchTerm = "search_term_view.search_term";
        public static final String status = "search_term_view.status";
    }

    public static class SharedCriterion {
        public static final String brandDisplayName = "shared_criterion.brand.display_name";
        public static final String brandEntityId = "shared_criterion.brand.entity_id";
        public static final String brandPrimaryUrl = "shared_criterion.brand.primary_url";
        public static final String brandRejectionReason = "shared_criterion.brand.rejection_reason";
        public static final String brandStatus = "shared_criterion.brand.status";
        public static final String criterionId = "shared_criterion.criterion_id";
        public static final String keywordMatchType = "shared_criterion.keyword.match_type";
        public static final String keywordText = "shared_criterion.keyword.text";
        public static final String mobileAppCategoryMobileAppCategoryConstant = "shared_criterion.mobile_app_category.mobile_app_category_constant";
        public static final String mobileApplicationAppId = "shared_criterion.mobile_application.app_id";
        public static final String mobileApplicationName = "shared_criterion.mobile_application.name";
        public static final String placementUrl = "shared_criterion.placement.url";
        public static final String resourceName = "shared_criterion.resource_name";
        public static final String sharedSet = "shared_criterion.shared_set";
        public static final String type = "shared_criterion.type";
        public static final String youtubeChannelChannelId = "shared_criterion.youtube_channel.channel_id";
        public static final String youtubeVideoVideoId = "shared_criterion.youtube_video.video_id";
    }

    public static class SharedSet {
        public static final String id = "shared_set.id";
        public static final String memberCount = "shared_set.member_count";
        public static final String name = "shared_set.name";
        public static final String referenceCount = "shared_set.reference_count";
        public static final String resourceName = "shared_set.resource_name";
        public static final String status = "shared_set.status";
        public static final String type = "shared_set.type";
    }

    public static class ShoppingPerformanceView {
        public static final String resourceName = "shopping_performance_view.resource_name";
    }

    public static class SmartCampaignSearchTermView {
        public static final String campaign = "smart_campaign_search_term_view.campaign";
        public static final String resourceName = "smart_campaign_search_term_view.resource_name";
        public static final String searchTerm = "smart_campaign_search_term_view.search_term";
    }

    public static class SmartCampaignSetting {
        public static final String adOptimizedBusinessProfileSettingIncludeLeadForm = "smart_campaign_setting.ad_optimized_business_profile_setting.include_lead_form";
        public static final String advertisingLanguageCode = "smart_campaign_setting.advertising_language_code";
        public static final String businessName = "smart_campaign_setting.business_name";
        public static final String businessProfileLocation = "smart_campaign_setting.business_profile_location";
        public static final String campaign = "smart_campaign_setting.campaign";
        public static final String finalUrl = "smart_campaign_setting.final_url";
        public static final String phoneNumberCountryCode = "smart_campaign_setting.phone_number.country_code";
        public static final String phoneNumberPhoneNumber = "smart_campaign_setting.phone_number.phone_number";
        public static final String resourceName = "smart_campaign_setting.resource_name";
    }

    public static class ThirdPartyAppAnalyticsLink {
        public static final String resourceName = "third_party_app_analytics_link.resource_name";
        public static final String shareableLinkId = "third_party_app_analytics_link.shareable_link_id";
    }

    public static class TopicConstant {
        public static final String id = "topic_constant.id";
        public static final String path = "topic_constant.path";
        public static final String resourceName = "topic_constant.resource_name";
        public static final String topicConstantParent = "topic_constant.topic_constant_parent";
    }

    public static class TopicView {
        public static final String resourceName = "topic_view.resource_name";
    }

    public static class TravelActivityGroupView {
        public static final String resourceName = "travel_activity_group_view.resource_name";
    }

    public static class TravelActivityPerformanceView {
        public static final String resourceName = "travel_activity_performance_view.resource_name";
    }

    public static class UserInterest {
        public static final String availabilities = "user_interest.availabilities";
        public static final String launchedToAll = "user_interest.launched_to_all";
        public static final String name = "user_interest.name";
        public static final String resourceName = "user_interest.resource_name";
        public static final String taxonomyType = "user_interest.taxonomy_type";
        public static final String userInterestId = "user_interest.user_interest_id";
        public static final String userInterestParent = "user_interest.user_interest_parent";
    }

    public static class UserList {
        public static final String accessReason = "user_list.access_reason";
        public static final String accountUserListStatus = "user_list.account_user_list_status";
        public static final String basicUserListActions = "user_list.basic_user_list.actions";
        public static final String closingReason = "user_list.closing_reason";
        public static final String crmBasedUserListAppId = "user_list.crm_based_user_list.app_id";
        public static final String crmBasedUserListDataSourceType = "user_list.crm_based_user_list.data_source_type";
        public static final String crmBasedUserListUploadKeyType = "user_list.crm_based_user_list.upload_key_type";
        public static final String description = "user_list.description";
        public static final String eligibleForDisplay = "user_list.eligible_for_display";
        public static final String eligibleForSearch = "user_list.eligible_for_search";
        public static final String id = "user_list.id";
        public static final String integrationCode = "user_list.integration_code";
        public static final String logicalUserListRules = "user_list.logical_user_list.rules";
        public static final String lookalikeUserListCountryCodes = "user_list.lookalike_user_list.country_codes";
        public static final String lookalikeUserListExpansionLevel = "user_list.lookalike_user_list.expansion_level";
        public static final String lookalikeUserListSeedUserListIds = "user_list.lookalike_user_list.seed_user_list_ids";
        public static final String matchRatePercentage = "user_list.match_rate_percentage";
        public static final String membershipLifeSpan = "user_list.membership_life_span";
        public static final String membershipStatus = "user_list.membership_status";
        public static final String name = "user_list.name";
        public static final String readOnly = "user_list.read_only";
        public static final String resourceName = "user_list.resource_name";
        public static final String ruleBasedUserListFlexibleRuleUserListExclusiveOperands = "user_list.rule_based_user_list.flexible_rule_user_list.exclusive_operands";
        public static final String ruleBasedUserListFlexibleRuleUserListInclusiveOperands = "user_list.rule_based_user_list.flexible_rule_user_list.inclusive_operands";
        public static final String ruleBasedUserListFlexibleRuleUserListInclusiveRuleOperator = "user_list.rule_based_user_list.flexible_rule_user_list.inclusive_rule_operator";
        public static final String ruleBasedUserListPrepopulationStatus = "user_list.rule_based_user_list.prepopulation_status";
        public static final String similarUserListSeedUserList = "user_list.similar_user_list.seed_user_list";
        public static final String sizeForDisplay = "user_list.size_for_display";
        public static final String sizeForSearch = "user_list.size_for_search";
        public static final String sizeRangeForDisplay = "user_list.size_range_for_display";
        public static final String sizeRangeForSearch = "user_list.size_range_for_search";
        public static final String type = "user_list.type";
    }

    public static class UserLocationView {
        public static final String countryCriterionId = "user_location_view.country_criterion_id";
        public static final String resourceName = "user_location_view.resource_name";
        public static final String targetingLocation = "user_location_view.targeting_location";
    }

    public static class Video {
        public static final String channelId = "video.channel_id";
        public static final String durationMillis = "video.duration_millis";
        public static final String id = "video.id";
        public static final String resourceName = "video.resource_name";
        public static final String title = "video.title";
    }

    public static class WebpageView {
        public static final String resourceName = "webpage_view.resource_name";
    }

}
