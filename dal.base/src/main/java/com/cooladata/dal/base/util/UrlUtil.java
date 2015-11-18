package com.cooladata.dal.base.util;

import com.cooladata.dal.base.constants.EntityApiConstants;


public class UrlUtil {

	public static String WEBSITE = "/website/";
	
	public static String groupUrl = "/"+EntityApiConstants.GROUP_ACTION;
	public static String groupPermissionUrl = "/"+EntityApiConstants.PERMISSIONS;
	public static String userPermissionUrl = "/"+EntityApiConstants.PERMISSIONS;;
	public static String user = "/"+EntityApiConstants.USER_ACTION;
	public static String customer = "/"+EntityApiConstants.CUSTOMER_ACTION;
	public static String dataColumn = "/"+EntityApiConstants.DATA_COULMN;
	
	public static String DataModelConfig = "";
	public static String Event = "";
	public static String EventCategory = "";
	public static String FDLSystemConfigurator = "";
	public static String Partition = "";
	public static String Project = EntityApiConstants.PROJECTS_ACTION;
	
	public static String DataSource = WEBSITE + EntityApiConstants.DATASOURCE_ACTION;
	public static String DataSourceType = WEBSITE + EntityApiConstants.DATASOURCETYPE_ACTION;
	public static String Document = WEBSITE + EntityApiConstants.DOCUMENT_ACTION;
	public static String PromotionGroup = WEBSITE + EntityApiConstants.PROMOTION_GROUP;
	public static String Querytemplate = WEBSITE + EntityApiConstants.QUERY_TEMPLATE_ACTION;
	public static String Sheet = WEBSITE + EntityApiConstants.SHEET;;
	public static String Slicer = WEBSITE + EntityApiConstants.SLICER;
	public static String Visualization = WEBSITE + EntityApiConstants.VISUALIZATION;
	public static String WidgetInstance = WEBSITE + EntityApiConstants.WIDGET_INSTANCE;;
	public static String WidgetType = WEBSITE + EntityApiConstants.WIDGET_TYPE;;
	public static String permission = WEBSITE + EntityApiConstants.PERMISSIONS;;
}
