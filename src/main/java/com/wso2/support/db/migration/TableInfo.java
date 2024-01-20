package com.wso2.support.db.migration;

import com.wso2.support.db.migration.util.Logger;

import java.sql.Types;
import java.util.*;

public class TableInfo {
    
    public Map<String, List<ColumnInfo>> getTableInfo(String wso2_db)
    {
        if (wso2_db.equalsIgnoreCase(("AM_DB")))
        {
            return getTableInfo_AM_DB();
        } else if (wso2_db.equalsIgnoreCase(("REG_DB"))) {
            return getTableInfo_REG_DB();
        }
        Logger.error("wso2_db type is wrong in configuration.toml file. ");
        return null;
    }



    private Map<String, List<ColumnInfo>> getTableInfo_AM_DB()
    {
        Map<String, List<ColumnInfo>> tableInfo = new LinkedHashMap<>();

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("PRODUCT_NAME", Types.VARCHAR)
            );

            tableInfo.put("IDN_BASE_TABLE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("CONSUMER_KEY", Types.VARCHAR),
                    new ColumnInfo("CONSUMER_SECRET", Types.VARCHAR),
                    new ColumnInfo("USERNAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("USER_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("APP_NAME", Types.VARCHAR),
                    new ColumnInfo("OAUTH_VERSION", Types.VARCHAR),
                    new ColumnInfo("CALLBACK_URL", Types.VARCHAR),
                    new ColumnInfo("GRANT_TYPES", Types.VARCHAR),
                    new ColumnInfo("PKCE_MANDATORY", Types.CHAR),
                    new ColumnInfo("PKCE_SUPPORT_PLAIN", Types.CHAR),
                    new ColumnInfo("APP_STATE", Types.VARCHAR)
            );

            tableInfo.put("IDN_OAUTH_CONSUMER_APPS", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("REQUEST_TOKEN", Types.VARCHAR),
                    new ColumnInfo("REQUEST_TOKEN_SECRET", Types.VARCHAR),
                    new ColumnInfo("CONSUMER_KEY_ID", Types.INTEGER),
                    new ColumnInfo("CALLBACK_URL", Types.VARCHAR),
                    new ColumnInfo("SCOPE", Types.VARCHAR),
                    new ColumnInfo("AUTHORIZED", Types.VARCHAR),
                    new ColumnInfo("OAUTH_VERIFIER", Types.VARCHAR),
                    new ColumnInfo("AUTHZ_USER", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_OAUTH1A_REQUEST_TOKEN", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ACCESS_TOKEN", Types.VARCHAR),
                    new ColumnInfo("ACCESS_TOKEN_SECRET", Types.VARCHAR),
                    new ColumnInfo("CONSUMER_KEY_ID", Types.INTEGER),
                    new ColumnInfo("SCOPE", Types.VARCHAR),
                    new ColumnInfo("AUTHZ_USER", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_OAUTH1A_ACCESS_TOKEN", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("TOKEN_ID", Types.VARCHAR),
                    new ColumnInfo("ACCESS_TOKEN", Types.VARCHAR),
                    new ColumnInfo("REFRESH_TOKEN", Types.VARCHAR),
                    new ColumnInfo("CONSUMER_KEY_ID", Types.INTEGER),
                    new ColumnInfo("AUTHZ_USER", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("USER_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("USER_TYPE", Types.VARCHAR),
                    new ColumnInfo("GRANT_TYPE", Types.VARCHAR),
                    new ColumnInfo("TIME_CREATED", Types.TIMESTAMP),
                    new ColumnInfo("REFRESH_TOKEN_TIME_CREATED", Types.TIMESTAMP),
                    new ColumnInfo("VALIDITY_PERIOD", Types.BIGINT),
                    new ColumnInfo("REFRESH_TOKEN_VALIDITY_PERIOD", Types.BIGINT),
                    new ColumnInfo("TOKEN_SCOPE_HASH", Types.VARCHAR),
                    new ColumnInfo("TOKEN_STATE", Types.VARCHAR),
                    new ColumnInfo("TOKEN_STATE_ID", Types.VARCHAR),
                    new ColumnInfo("SUBJECT_IDENTIFIER", Types.VARCHAR)
            );

            tableInfo.put("IDN_OAUTH2_ACCESS_TOKEN", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("CODE_ID", Types.VARCHAR),
                    new ColumnInfo("AUTHORIZATION_CODE", Types.VARCHAR),
                    new ColumnInfo("CONSUMER_KEY_ID", Types.INTEGER),
                    new ColumnInfo("CALLBACK_URL", Types.VARCHAR),
                    new ColumnInfo("SCOPE", Types.VARCHAR),
                    new ColumnInfo("AUTHZ_USER", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("USER_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("TIME_CREATED", Types.TIMESTAMP),
                    new ColumnInfo("VALIDITY_PERIOD", Types.BIGINT),
                    new ColumnInfo("STATE", Types.VARCHAR),
                    new ColumnInfo("TOKEN_ID", Types.VARCHAR),
                    new ColumnInfo("SUBJECT_IDENTIFIER", Types.VARCHAR),
                    new ColumnInfo("PKCE_CODE_CHALLENGE", Types.VARCHAR),
                    new ColumnInfo("PKCE_CODE_CHALLENGE_METHOD", Types.VARCHAR)
            );

            tableInfo.put("IDN_OAUTH2_AUTHORIZATION_CODE", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("TOKEN_ID", Types.VARCHAR),
                    new ColumnInfo("TOKEN_SCOPE", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_OAUTH2_ACCESS_TOKEN_SCOPE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("SCOPE_ID", Types.INTEGER),
                    new ColumnInfo("SCOPE_KEY", Types.VARCHAR),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("ROLES", Types.VARCHAR)
            );

            tableInfo.put("IDN_OAUTH2_SCOPE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("RESOURCE_PATH", Types.VARCHAR),
                    new ColumnInfo("SCOPE_ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_OAUTH2_RESOURCE_SCOPE", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("ROLE_NAME", Types.VARCHAR),
                    new ColumnInfo("ATTR_NAME", Types.VARCHAR),
                    new ColumnInfo("ATTR_VALUE", Types.VARCHAR)
            );

            tableInfo.put("IDN_SCIM_GROUP", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("COOKIE_VALUE", Types.VARCHAR),
                    new ColumnInfo("CREATED_TIME", Types.TIMESTAMP)
            );

            tableInfo.put("IDN_OPENID_REMEMBER_ME", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("RP_URL", Types.VARCHAR),
                    new ColumnInfo("TRUSTED_ALWAYS", Types.VARCHAR),
                    new ColumnInfo("LAST_VISIT", Types.DATE),
                    new ColumnInfo("VISIT_COUNT", Types.INTEGER),
                    new ColumnInfo("DEFAULT_PROFILE_NAME", Types.VARCHAR)
            );

            tableInfo.put("IDN_OPENID_USER_RPS", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("HANDLE", Types.VARCHAR),
                    new ColumnInfo("ASSOC_TYPE", Types.VARCHAR),
                    new ColumnInfo("EXPIRE_IN", Types.TIMESTAMP),
                    new ColumnInfo("MAC_KEY", Types.VARCHAR),
                    new ColumnInfo("ASSOC_STORE", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_OPENID_ASSOCIATIONS", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TOKEN_ID", Types.VARCHAR),
                    new ColumnInfo("TOKEN_CONTENT", Types.BLOB),
                    new ColumnInfo("CREATE_DATE", Types.TIMESTAMP),
                    new ColumnInfo("EXPIRE_DATE", Types.TIMESTAMP),
                    new ColumnInfo("STATE", Types.INTEGER)
            );

            tableInfo.put("IDN_STS_STORE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("DATA_KEY", Types.VARCHAR),
                    new ColumnInfo("DATA_VALUE", Types.VARCHAR)
            );

            tableInfo.put("IDN_IDENTITY_USER_DATA", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("METADATA_TYPE", Types.VARCHAR),
                    new ColumnInfo("METADATA", Types.VARCHAR),
                    new ColumnInfo("VALID", Types.VARCHAR)
            );

            tableInfo.put("IDN_IDENTITY_META_DATA", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("SESSION_ID", Types.VARCHAR),
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("CREATED_TIME", Types.VARCHAR),
                    new ColumnInfo("LAST_MODIFIED_TIME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_THRIFT_SESSION", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("SESSION_ID", Types.VARCHAR),
                    new ColumnInfo("SESSION_TYPE", Types.VARCHAR),
                    new ColumnInfo("OPERATION", Types.VARCHAR),
                    new ColumnInfo("SESSION_OBJECT", Types.BLOB),
                    new ColumnInfo("TIME_CREATED", Types.BIGINT),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_AUTH_SESSION_STORE", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("APP_NAME", Types.VARCHAR),
                    new ColumnInfo("USER_STORE", Types.VARCHAR),
                    new ColumnInfo("USERNAME", Types.VARCHAR),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("ROLE_CLAIM", Types.VARCHAR),
                    new ColumnInfo("AUTH_TYPE", Types.VARCHAR),
                    new ColumnInfo("PROVISIONING_USERSTORE_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("IS_LOCAL_CLAIM_DIALECT", Types.CHAR),
                    new ColumnInfo("IS_SEND_LOCAL_SUBJECT_ID", Types.CHAR),
                    new ColumnInfo("IS_SEND_AUTH_LIST_OF_IDPS", Types.CHAR),
                    new ColumnInfo("IS_USE_TENANT_DOMAIN_SUBJECT", Types.CHAR),
                    new ColumnInfo("IS_USE_USER_DOMAIN_SUBJECT", Types.CHAR),
                    new ColumnInfo("ENABLE_AUTHORIZATION", Types.CHAR),
                    new ColumnInfo("SUBJECT_CLAIM_URI", Types.VARCHAR),
                    new ColumnInfo("IS_SAAS_APP", Types.CHAR),
                    new ColumnInfo("IS_DUMB_MODE", Types.CHAR)
            );

            tableInfo.put("SP_APP", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("SP_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("VALUE", Types.VARCHAR),
                    new ColumnInfo("DISPLAY_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("SP_METADATA", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("INBOUND_AUTH_KEY", Types.VARCHAR),
                    new ColumnInfo("INBOUND_AUTH_TYPE", Types.VARCHAR),
                    new ColumnInfo("INBOUND_CONFIG_TYPE", Types.VARCHAR),
                    new ColumnInfo("PROP_NAME", Types.VARCHAR),
                    new ColumnInfo("PROP_VALUE", Types.VARCHAR),
                    new ColumnInfo("APP_ID", Types.INTEGER)
            );

            tableInfo.put("SP_INBOUND_AUTH", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("STEP_ORDER", Types.INTEGER),
                    new ColumnInfo("APP_ID", Types.INTEGER),
                    new ColumnInfo("IS_SUBJECT_STEP", Types.CHAR),
                    new ColumnInfo("IS_ATTRIBUTE_STEP", Types.CHAR)
            );

            tableInfo.put("SP_AUTH_STEP", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("AUTHENTICATOR_ID", Types.INTEGER)
            );

            tableInfo.put("SP_FEDERATED_IDP", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("IDP_CLAIM", Types.VARCHAR),
                    new ColumnInfo("SP_CLAIM", Types.VARCHAR),
                    new ColumnInfo("APP_ID", Types.INTEGER),
                    new ColumnInfo("IS_REQUESTED", Types.VARCHAR),
                    new ColumnInfo("IS_MANDATORY", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_VALUE", Types.VARCHAR)
            );

            tableInfo.put("SP_CLAIM_MAPPING", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("IDP_ROLE", Types.VARCHAR),
                    new ColumnInfo("SP_ROLE", Types.VARCHAR),
                    new ColumnInfo("APP_ID", Types.INTEGER)
            );

            tableInfo.put("SP_ROLE_MAPPING", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("AUTHENTICATOR_NAME", Types.VARCHAR),
                    new ColumnInfo("APP_ID", Types.INTEGER)
            );

            tableInfo.put("SP_REQ_PATH_AUTHENTICATOR", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("IDP_NAME", Types.VARCHAR),
                    new ColumnInfo("CONNECTOR_NAME", Types.VARCHAR),
                    new ColumnInfo("APP_ID", Types.INTEGER),
                    new ColumnInfo("IS_JIT_ENABLED", Types.CHAR),
                    new ColumnInfo("BLOCKING", Types.CHAR),
                    new ColumnInfo("RULE_ENABLED", Types.CHAR)
            );

            tableInfo.put("SP_PROVISIONING_CONNECTOR", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("IS_ENABLED", Types.CHAR),
                    new ColumnInfo("IS_PRIMARY", Types.CHAR),
                    new ColumnInfo("HOME_REALM_ID", Types.VARCHAR),
                    new ColumnInfo("IMAGE", Types.BLOB),
                    new ColumnInfo("CERTIFICATE", Types.BLOB),
                    new ColumnInfo("ALIAS", Types.VARCHAR),
                    new ColumnInfo("INBOUND_PROV_ENABLED", Types.CHAR),
                    new ColumnInfo("INBOUND_PROV_USER_STORE_ID", Types.VARCHAR),
                    new ColumnInfo("USER_CLAIM_URI", Types.VARCHAR),
                    new ColumnInfo("ROLE_CLAIM_URI", Types.VARCHAR),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_AUTHENTICATOR_NAME", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_PRO_CONNECTOR_NAME", Types.VARCHAR),
                    new ColumnInfo("PROVISIONING_ROLE", Types.VARCHAR),
                    new ColumnInfo("IS_FEDERATION_HUB", Types.CHAR),
                    new ColumnInfo("IS_LOCAL_CLAIM_DIALECT", Types.CHAR),
                    new ColumnInfo("DISPLAY_NAME", Types.VARCHAR)
            );

            tableInfo.put("IDP", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("IDP_ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("ROLE", Types.VARCHAR)
            );

            tableInfo.put("IDP_ROLE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("IDP_ROLE_ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("USER_STORE_ID", Types.VARCHAR),
                    new ColumnInfo("LOCAL_ROLE", Types.VARCHAR)
            );

            tableInfo.put("IDP_ROLE_MAPPING", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("IDP_ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("CLAIM", Types.VARCHAR)
            );

            tableInfo.put("IDP_CLAIM", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("IDP_CLAIM_ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("LOCAL_CLAIM", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_VALUE", Types.VARCHAR),
                    new ColumnInfo("IS_REQUESTED", Types.VARCHAR)
            );

            tableInfo.put("IDP_CLAIM_MAPPING", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("IDP_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("IS_ENABLED", Types.CHAR),
                    new ColumnInfo("DISPLAY_NAME", Types.VARCHAR)
            );

            tableInfo.put("IDP_AUTHENTICATOR", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("IDP_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("VALUE", Types.VARCHAR),
                    new ColumnInfo("DISPLAY_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDP_METADATA", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("AUTHENTICATOR_ID", Types.INTEGER),
                    new ColumnInfo("PROPERTY_KEY", Types.VARCHAR),
                    new ColumnInfo("PROPERTY_VALUE", Types.VARCHAR),
                    new ColumnInfo("IS_SECRET", Types.CHAR)
            );

            tableInfo.put("IDP_AUTHENTICATOR_PROPERTY", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("IDP_ID", Types.INTEGER),
                    new ColumnInfo("PROVISIONING_CONNECTOR_TYPE", Types.VARCHAR),
                    new ColumnInfo("IS_ENABLED", Types.CHAR),
                    new ColumnInfo("IS_BLOCKING", Types.CHAR),
                    new ColumnInfo("IS_RULES_ENABLED", Types.CHAR)
            );

            tableInfo.put("IDP_PROVISIONING_CONFIG", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("PROVISIONING_CONFIG_ID", Types.INTEGER),
                    new ColumnInfo("PROPERTY_KEY", Types.VARCHAR),
                    new ColumnInfo("PROPERTY_VALUE", Types.VARCHAR),
                    new ColumnInfo("PROPERTY_BLOB_VALUE", Types.BLOB),
                    new ColumnInfo("PROPERTY_TYPE", Types.CHAR),
                    new ColumnInfo("IS_SECRET", Types.CHAR)
            );

            tableInfo.put("IDP_PROV_CONFIG_PROPERTY", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("PROVISIONING_CONFIG_ID", Types.INTEGER),
                    new ColumnInfo("ENTITY_TYPE", Types.VARCHAR),
                    new ColumnInfo("ENTITY_LOCAL_USERSTORE", Types.VARCHAR),
                    new ColumnInfo("ENTITY_NAME", Types.VARCHAR),
                    new ColumnInfo("ENTITY_VALUE", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("ENTITY_LOCAL_ID", Types.VARCHAR)
            );

            tableInfo.put("IDP_PROVISIONING_ENTITY", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("IDP_ID", Types.INTEGER),
                    new ColumnInfo("CLAIM_URI", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_VALUE", Types.VARCHAR),
                    new ColumnInfo("IS_REQUESTED", Types.VARCHAR)
            );

            tableInfo.put("IDP_LOCAL_CLAIM", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("IDP_USER_ID", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("IDP_ID", Types.INTEGER),
                    new ColumnInfo("DOMAIN_NAME", Types.VARCHAR),
                    new ColumnInfo("USER_NAME", Types.VARCHAR)
            );

            tableInfo.put("IDN_ASSOCIATED_ID", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ASSOCIATION_KEY", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("DOMAIN_NAME", Types.VARCHAR),
                    new ColumnInfo("USER_NAME", Types.VARCHAR)
            );

            tableInfo.put("IDN_USER_ACCOUNT_ASSOCIATION", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("DOMAIN_NAME", Types.VARCHAR),
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("TIME_REGISTERED", Types.TIMESTAMP),
                    new ColumnInfo("KEY_HANDLE", Types.VARCHAR),
                    new ColumnInfo("DEVICE_DATA", Types.LONGVARCHAR)
            );

            tableInfo.put("FIDO_DEVICE_STORE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("UUID", Types.VARCHAR),
                    new ColumnInfo("CREATED_BY", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("OPERATION_TYPE", Types.VARCHAR),
                    new ColumnInfo("CREATED_AT", Types.TIMESTAMP),
                    new ColumnInfo("UPDATED_AT", Types.TIMESTAMP),
                    new ColumnInfo("STATUS", Types.VARCHAR),
                    new ColumnInfo("REQUEST", Types.BLOB)
            );

            tableInfo.put("WF_REQUEST", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("PROFILE_NAME", Types.VARCHAR),
                    new ColumnInfo("HOST_URL_MANAGER", Types.VARCHAR),
                    new ColumnInfo("HOST_URL_WORKER", Types.VARCHAR),
                    new ColumnInfo("USERNAME", Types.VARCHAR),
                    new ColumnInfo("PASSWORD", Types.VARCHAR),
                    new ColumnInfo("CALLBACK_HOST", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("WF_BPS_PROFILE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.VARCHAR),
                    new ColumnInfo("WF_NAME", Types.VARCHAR),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("TEMPLATE_ID", Types.VARCHAR),
                    new ColumnInfo("IMPL_ID", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("WF_WORKFLOW", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("ASSOC_NAME", Types.VARCHAR),
                    new ColumnInfo("EVENT_ID", Types.VARCHAR),
                    new ColumnInfo("ASSOC_CONDITION", Types.VARCHAR),
                    new ColumnInfo("WORKFLOW_ID", Types.VARCHAR),
                    new ColumnInfo("IS_ENABLED", Types.CHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("WF_WORKFLOW_ASSOCIATION", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("WORKFLOW_ID", Types.VARCHAR),
                    new ColumnInfo("PARAM_NAME", Types.VARCHAR),
                    new ColumnInfo("PARAM_VALUE", Types.VARCHAR),
                    new ColumnInfo("PARAM_QNAME", Types.VARCHAR),
                    new ColumnInfo("PARAM_HOLDER", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("WF_WORKFLOW_CONFIG_PARAM", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("REQUEST_ID", Types.VARCHAR),
                    new ColumnInfo("ENTITY_NAME", Types.VARCHAR),
                    new ColumnInfo("ENTITY_TYPE", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("WF_REQUEST_ENTITY_RELATIONSHIP", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("RELATIONSHIP_ID", Types.VARCHAR),
                    new ColumnInfo("WORKFLOW_ID", Types.VARCHAR),
                    new ColumnInfo("REQUEST_ID", Types.VARCHAR),
                    new ColumnInfo("UPDATED_AT", Types.TIMESTAMP),
                    new ColumnInfo("STATUS", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("WF_WORKFLOW_REQUEST_RELATION", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("USER_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("CODE", Types.VARCHAR),
                    new ColumnInfo("SCENARIO", Types.VARCHAR),
                    new ColumnInfo("STEP", Types.VARCHAR),
                    new ColumnInfo("TIME_CREATED", Types.TIMESTAMP),
                    new ColumnInfo("REMAINING_SETS", Types.VARCHAR)
            );

            tableInfo.put("IDN_RECOVERY_DATA", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("USER_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("SALT_VALUE", Types.VARCHAR),
                    new ColumnInfo("HASH", Types.VARCHAR),
                    new ColumnInfo("TIME_CREATED", Types.TIMESTAMP)
            );

            tableInfo.put("IDN_PASSWORD_HISTORY_DATA", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("DIALECT_URI", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_CLAIM_DIALECT", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("DIALECT_ID", Types.INTEGER),
                    new ColumnInfo("CLAIM_URI", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_CLAIM", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("LOCAL_CLAIM_ID", Types.INTEGER),
                    new ColumnInfo("USER_STORE_DOMAIN_NAME", Types.VARCHAR),
                    new ColumnInfo("ATTRIBUTE_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_CLAIM_MAPPED_ATTRIBUTE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("LOCAL_CLAIM_ID", Types.INTEGER),
                    new ColumnInfo("PROPERTY_NAME", Types.VARCHAR),
                    new ColumnInfo("PROPERTY_VALUE", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_CLAIM_PROPERTY", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("EXT_CLAIM_ID", Types.INTEGER),
                    new ColumnInfo("MAPPED_LOCAL_CLAIM_ID", Types.INTEGER),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("IDN_CLAIM_MAPPING", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ID", Types.INTEGER),
                    new ColumnInfo("SAML2_ID", Types.VARCHAR),
                    new ColumnInfo("SAML2_ISSUER", Types.VARCHAR),
                    new ColumnInfo("SAML2_SUBJECT", Types.VARCHAR),
                    new ColumnInfo("SAML2_SESSION_INDEX", Types.VARCHAR),
                    new ColumnInfo("SAML2_AUTHN_CONTEXT_CLASS_REF", Types.VARCHAR),
                    new ColumnInfo("SAML2_ASSERTION", Types.VARCHAR)
            );

            tableInfo.put("IDN_SAML2_ASSERTION_STORE", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("SUBSCRIBER_ID", Types.INTEGER),
                    new ColumnInfo("USER_ID", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("EMAIL_ADDRESS", Types.VARCHAR),
                    new ColumnInfo("DATE_SUBSCRIBED", Types.TIMESTAMP),
                    new ColumnInfo("CREATED_BY", Types.VARCHAR),
                    new ColumnInfo("CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UPDATED_BY", Types.VARCHAR),
                    new ColumnInfo("UPDATED_TIME", Types.TIMESTAMP)
            );

            tableInfo.put("AM_SUBSCRIBER", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("APPLICATION_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("SUBSCRIBER_ID", Types.INTEGER),
                    new ColumnInfo("APPLICATION_TIER", Types.VARCHAR),
                    new ColumnInfo("CALLBACK_URL", Types.VARCHAR),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("APPLICATION_STATUS", Types.VARCHAR),
                    new ColumnInfo("GROUP_ID", Types.VARCHAR),
                    new ColumnInfo("CREATED_BY", Types.VARCHAR),
                    new ColumnInfo("CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UPDATED_BY", Types.VARCHAR),
                    new ColumnInfo("UPDATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UUID", Types.VARCHAR)
            );

            tableInfo.put("AM_APPLICATION", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("API_ID", Types.INTEGER),
                    new ColumnInfo("API_PROVIDER", Types.VARCHAR),
                    new ColumnInfo("API_NAME", Types.VARCHAR),
                    new ColumnInfo("API_VERSION", Types.VARCHAR),
                    new ColumnInfo("CONTEXT", Types.VARCHAR),
                    new ColumnInfo("CONTEXT_TEMPLATE", Types.VARCHAR),
                    new ColumnInfo("API_TIER", Types.VARCHAR),
                    new ColumnInfo("CREATED_BY", Types.VARCHAR),
                    new ColumnInfo("CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UPDATED_BY", Types.VARCHAR),
                    new ColumnInfo("UPDATED_TIME", Types.TIMESTAMP)
            );

            tableInfo.put("AM_API", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("URL_MAPPING_ID", Types.INTEGER),
                    new ColumnInfo("API_ID", Types.INTEGER),
                    new ColumnInfo("HTTP_METHOD", Types.VARCHAR),
                    new ColumnInfo("AUTH_SCHEME", Types.VARCHAR),
                    new ColumnInfo("URL_PATTERN", Types.VARCHAR),
                    new ColumnInfo("THROTTLING_TIER", Types.VARCHAR),
                    new ColumnInfo("MEDIATION_SCRIPT", Types.BLOB)
            );

            tableInfo.put("AM_API_URL_MAPPING", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("SUBSCRIPTION_ID", Types.INTEGER),
                    new ColumnInfo("TIER_ID", Types.VARCHAR),
                    new ColumnInfo("API_ID", Types.INTEGER),
                    new ColumnInfo("LAST_ACCESSED", Types.TIMESTAMP),
                    new ColumnInfo("APPLICATION_ID", Types.INTEGER),
                    new ColumnInfo("SUB_STATUS", Types.VARCHAR),
                    new ColumnInfo("SUBS_CREATE_STATE", Types.VARCHAR),
                    new ColumnInfo("CREATED_BY", Types.VARCHAR),
                    new ColumnInfo("CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UPDATED_BY", Types.VARCHAR),
                    new ColumnInfo("UPDATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UUID", Types.VARCHAR)
            );

            tableInfo.put("AM_SUBSCRIPTION", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("SUBSCRIPTION_ID", Types.INTEGER),
                    new ColumnInfo("ACCESS_TOKEN", Types.VARCHAR),
                    new ColumnInfo("KEY_TYPE", Types.VARCHAR)
            );

            tableInfo.put("AM_SUBSCRIPTION_KEY_MAPPING", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("APPLICATION_ID", Types.INTEGER),
                    new ColumnInfo("CONSUMER_KEY", Types.VARCHAR),
                    new ColumnInfo("KEY_TYPE", Types.VARCHAR),
                    new ColumnInfo("STATE", Types.VARCHAR),
                    new ColumnInfo("CREATE_MODE", Types.VARCHAR)
            );

            tableInfo.put("AM_APPLICATION_KEY_MAPPING", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("EVENT_ID", Types.INTEGER),
                    new ColumnInfo("API_ID", Types.INTEGER),
                    new ColumnInfo("PREVIOUS_STATE", Types.VARCHAR),
                    new ColumnInfo("NEW_STATE", Types.VARCHAR),
                    new ColumnInfo("USER_ID", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("EVENT_DATE", Types.TIMESTAMP)
            );

            tableInfo.put("AM_API_LC_EVENT", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("CONSUMER_KEY", Types.VARCHAR),
                    new ColumnInfo("AUTHZ_DOMAIN", Types.VARCHAR)
            );

            tableInfo.put("AM_APP_KEY_DOMAIN_MAPPING", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("COMMENT_ID", Types.INTEGER),
                    new ColumnInfo("COMMENT_TEXT", Types.VARCHAR),
                    new ColumnInfo("COMMENTED_USER", Types.VARCHAR),
                    new ColumnInfo("DATE_COMMENTED", Types.TIMESTAMP),
                    new ColumnInfo("API_ID", Types.INTEGER)
            );

            tableInfo.put("AM_API_COMMENTS", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("RATING_ID", Types.INTEGER),
                    new ColumnInfo("API_ID", Types.INTEGER),
                    new ColumnInfo("RATING", Types.INTEGER),
                    new ColumnInfo("SUBSCRIBER_ID", Types.INTEGER)
            );

            tableInfo.put("AM_API_RATINGS", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("TIER_PERMISSIONS_ID", Types.INTEGER),
                    new ColumnInfo("TIER", Types.VARCHAR),
                    new ColumnInfo("PERMISSIONS_TYPE", Types.VARCHAR),
                    new ColumnInfo("ROLES", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("AM_TIER_PERMISSIONS", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("APISTORE_ID", Types.INTEGER),
                    new ColumnInfo("API_ID", Types.INTEGER),
                    new ColumnInfo("STORE_ID", Types.VARCHAR),
                    new ColumnInfo("STORE_DISPLAY_NAME", Types.VARCHAR),
                    new ColumnInfo("STORE_ENDPOINT", Types.VARCHAR),
                    new ColumnInfo("STORE_TYPE", Types.VARCHAR)
            );

            tableInfo.put("AM_EXTERNAL_STORES", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("WF_ID", Types.INTEGER),
                    new ColumnInfo("WF_REFERENCE", Types.VARCHAR),
                    new ColumnInfo("WF_TYPE", Types.VARCHAR),
                    new ColumnInfo("WF_STATUS", Types.VARCHAR),
                    new ColumnInfo("WF_CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("WF_UPDATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("WF_STATUS_DESC", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("TENANT_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("WF_EXTERNAL_REFERENCE", Types.VARCHAR)
            );

            tableInfo.put("AM_WORKFLOWS", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("REG_ID", Types.INTEGER),
                    new ColumnInfo("SUBSCRIBER_ID", Types.INTEGER),
                    new ColumnInfo("WF_REF", Types.VARCHAR),
                    new ColumnInfo("APP_ID", Types.INTEGER),
                    new ColumnInfo("TOKEN_TYPE", Types.VARCHAR),
                    new ColumnInfo("TOKEN_SCOPE", Types.VARCHAR),
                    new ColumnInfo("INPUTS", Types.VARCHAR),
                    new ColumnInfo("ALLOWED_DOMAINS", Types.VARCHAR),
                    new ColumnInfo("VALIDITY_PERIOD", Types.BIGINT)
            );

            tableInfo.put("AM_APPLICATION_REGISTRATION", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("API_ID", Types.INTEGER),
                    new ColumnInfo("SCOPE_ID", Types.INTEGER)
            );

            tableInfo.put("AM_API_SCOPES", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("DEFAULT_VERSION_ID", Types.INTEGER),
                    new ColumnInfo("API_NAME", Types.VARCHAR),
                    new ColumnInfo("API_PROVIDER", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_API_VERSION", Types.VARCHAR),
                    new ColumnInfo("PUBLISHED_DEFAULT_API_VERSION", Types.VARCHAR)
            );

            tableInfo.put("AM_API_DEFAULT_VERSION", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ALERT_TYPE_ID", Types.INTEGER),
                    new ColumnInfo("ALERT_TYPE_NAME", Types.VARCHAR),
                    new ColumnInfo("STAKE_HOLDER", Types.VARCHAR)
            );

            tableInfo.put("AM_ALERT_TYPES", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("ALERT_TYPE_ID", Types.INTEGER),
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("STAKE_HOLDER", Types.VARCHAR)
            );

            tableInfo.put("AM_ALERT_TYPES_VALUES", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("EMAIL_LIST_ID", Types.INTEGER),
                    new ColumnInfo("USER_NAME", Types.VARCHAR),
                    new ColumnInfo("STAKE_HOLDER", Types.VARCHAR)
            );

            tableInfo.put("AM_ALERT_EMAILLIST", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("EMAIL_LIST_ID", Types.INTEGER),
                    new ColumnInfo("EMAIL", Types.VARCHAR)
            );

            tableInfo.put("AM_ALERT_EMAILLIST_DETAILS", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("POLICY_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("DISPLAY_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("QUOTA_TYPE", Types.VARCHAR),
                    new ColumnInfo("QUOTA", Types.INTEGER),
                    new ColumnInfo("QUOTA_UNIT", Types.VARCHAR),
                    new ColumnInfo("UNIT_TIME", Types.INTEGER),
                    new ColumnInfo("TIME_UNIT", Types.VARCHAR),
                    new ColumnInfo("RATE_LIMIT_COUNT", Types.INTEGER),
                    new ColumnInfo("RATE_LIMIT_TIME_UNIT", Types.VARCHAR),
                    new ColumnInfo("IS_DEPLOYED", Types.TINYINT),
                    new ColumnInfo("CUSTOM_ATTRIBUTES", Types.BLOB),
                    new ColumnInfo("STOP_ON_QUOTA_REACH", Types.BOOLEAN),
                    new ColumnInfo("BILLING_PLAN", Types.VARCHAR),
                    new ColumnInfo("UUID", Types.VARCHAR)
            );

            tableInfo.put("AM_POLICY_SUBSCRIPTION", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("POLICY_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("DISPLAY_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("QUOTA_TYPE", Types.VARCHAR),
                    new ColumnInfo("QUOTA", Types.INTEGER),
                    new ColumnInfo("QUOTA_UNIT", Types.VARCHAR),
                    new ColumnInfo("UNIT_TIME", Types.INTEGER),
                    new ColumnInfo("TIME_UNIT", Types.VARCHAR),
                    new ColumnInfo("IS_DEPLOYED", Types.TINYINT),
                    new ColumnInfo("CUSTOM_ATTRIBUTES", Types.BLOB),
                    new ColumnInfo("UUID", Types.VARCHAR)
            );

            tableInfo.put("AM_POLICY_APPLICATION", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("POLICY_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("QUOTA_TYPE", Types.VARCHAR),
                    new ColumnInfo("QUOTA", Types.INTEGER),
                    new ColumnInfo("QUOTA_UNIT", Types.VARCHAR),
                    new ColumnInfo("UNIT_TIME", Types.INTEGER),
                    new ColumnInfo("TIME_UNIT", Types.VARCHAR),
                    new ColumnInfo("IS_DEPLOYED", Types.TINYINT)
            );

            tableInfo.put("AM_POLICY_HARD_THROTTLING", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("POLICY_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("DISPLAY_NAME", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_QUOTA_TYPE", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_QUOTA", Types.INTEGER),
                    new ColumnInfo("DEFAULT_QUOTA_UNIT", Types.VARCHAR),
                    new ColumnInfo("DEFAULT_UNIT_TIME", Types.INTEGER),
                    new ColumnInfo("DEFAULT_TIME_UNIT", Types.VARCHAR),
                    new ColumnInfo("APPLICABLE_LEVEL", Types.VARCHAR),
                    new ColumnInfo("IS_DEPLOYED", Types.TINYINT),
                    new ColumnInfo("UUID", Types.VARCHAR)
            );

            tableInfo.put("AM_API_THROTTLE_POLICY", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("CONDITION_GROUP_ID", Types.INTEGER),
                    new ColumnInfo("POLICY_ID", Types.INTEGER),
                    new ColumnInfo("QUOTA_TYPE", Types.VARCHAR),
                    new ColumnInfo("QUOTA", Types.INTEGER),
                    new ColumnInfo("QUOTA_UNIT", Types.VARCHAR),
                    new ColumnInfo("UNIT_TIME", Types.INTEGER),
                    new ColumnInfo("TIME_UNIT", Types.VARCHAR),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR)
            );

            tableInfo.put("AM_CONDITION_GROUP", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("QUERY_PARAMETER_ID", Types.INTEGER),
                    new ColumnInfo("CONDITION_GROUP_ID", Types.INTEGER),
                    new ColumnInfo("PARAMETER_NAME", Types.VARCHAR),
                    new ColumnInfo("PARAMETER_VALUE", Types.VARCHAR),
                    new ColumnInfo("IS_PARAM_MAPPING", Types.BOOLEAN)
            );

            tableInfo.put("AM_QUERY_PARAMETER_CONDITION", tableColumns);
        }

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("HEADER_FIELD_ID", Types.INTEGER),
                    new ColumnInfo("CONDITION_GROUP_ID", Types.INTEGER),
                    new ColumnInfo("HEADER_FIELD_NAME", Types.VARCHAR),
                    new ColumnInfo("HEADER_FIELD_VALUE", Types.VARCHAR),
                    new ColumnInfo("IS_HEADER_FIELD_MAPPING", Types.BOOLEAN)
            );

            tableInfo.put("AM_HEADER_FIELD_CONDITION", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("JWT_CLAIM_ID", Types.INTEGER),
                    new ColumnInfo("CONDITION_GROUP_ID", Types.INTEGER),
                    new ColumnInfo("CLAIM_URI", Types.VARCHAR),
                    new ColumnInfo("CLAIM_ATTRIB", Types.VARCHAR),
                    new ColumnInfo("IS_CLAIM_MAPPING", Types.BOOLEAN)
            );

            tableInfo.put("AM_JWT_CLAIM_CONDITION", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("AM_IP_CONDITION_ID", Types.INTEGER),
                    new ColumnInfo("STARTING_IP", Types.VARCHAR),
                    new ColumnInfo("ENDING_IP", Types.VARCHAR),
                    new ColumnInfo("SPECIFIC_IP", Types.VARCHAR),
                    new ColumnInfo("WITHIN_IP_RANGE", Types.BOOLEAN),
                    new ColumnInfo("CONDITION_GROUP_ID", Types.INTEGER)
            );

            tableInfo.put("AM_IP_CONDITION", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("POLICY_ID", Types.INTEGER),
                    new ColumnInfo("NAME", Types.VARCHAR),
                    new ColumnInfo("KEY_TEMPLATE", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER),
                    new ColumnInfo("DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("SIDDHI_QUERY", Types.BLOB),
                    new ColumnInfo("IS_DEPLOYED", Types.TINYINT),
                    new ColumnInfo("UUID", Types.VARCHAR)
            );

            tableInfo.put("AM_POLICY_GLOBAL", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("THROTTLE_TIER_PERMISSIONS_ID", Types.INTEGER),
                    new ColumnInfo("TIER", Types.VARCHAR),
                    new ColumnInfo("PERMISSIONS_TYPE", Types.VARCHAR),
                    new ColumnInfo("ROLES", Types.VARCHAR),
                    new ColumnInfo("TENANT_ID", Types.INTEGER)
            );

            tableInfo.put("AM_THROTTLE_TIER_PERMISSIONS", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("CONDITION_ID", Types.INTEGER),
                    new ColumnInfo("TYPE", Types.VARCHAR),
                    new ColumnInfo("VALUE", Types.VARCHAR),
                    new ColumnInfo("ENABLED", Types.VARCHAR),
                    new ColumnInfo("DOMAIN", Types.VARCHAR),
                    new ColumnInfo("UUID", Types.VARCHAR)
            );

            tableInfo.put("AM_BLOCK_CONDITIONS", tableColumns);
        }
//        {
//            List<ColumnInfo> tableColumns = Arrays.asList(
//                    new ColumnInfo("TENANT_ID", Types.INTEGER),
//                    new ColumnInfo("ALIAS", Types.VARCHAR),
//                    new ColumnInfo("END_POINT", Types.VARCHAR)
//            );
//            tableInfo.put("AM_CERTIFICATE_METADATA", tableColumns);
//        }
//        {
//            List<ColumnInfo> tableColumns = Arrays.asList(
//                    new ColumnInfo("APPLICATION_ID", Types.INTEGER),
//                    new ColumnInfo("GROUP_ID", Types.VARCHAR),
//                    new ColumnInfo("TENANT", Types.VARCHAR),
//                    new ColumnInfo("TENANT_ID", Types.INTEGER)  // Added for consistency and potential foreign key
//            );
//            tableInfo.put("AM_APPLICATION_GROUP_MAPPING", tableColumns);
//        }

//
        return tableInfo;
    }

    private Map<String, List<ColumnInfo>> getTableInfo_REG_DB() {
        Map<String, List<ColumnInfo>> tableInfo = new LinkedHashMap<>();

        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("REG_LOCK_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_LOCK_STATUS", Types.VARCHAR),
                    new ColumnInfo("REG_LOCKED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_CLUSTER_LOCK", tableColumns);
        }
        {
            List<ColumnInfo> tableColumns = Arrays.asList(
                    new ColumnInfo("REG_LOG_ID", Types.INTEGER),
                    new ColumnInfo("REG_PATH", Types.VARCHAR),
                    new ColumnInfo("REG_USER_ID", Types.VARCHAR),
                    new ColumnInfo("REG_LOGGED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_ACTION", Types.INTEGER),
                    new ColumnInfo("REG_ACTION_DATA", Types.VARCHAR),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_LOG", tableColumns);
        }
        {
            List<ColumnInfo> pathColumns = Arrays.asList(
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_PATH_VALUE", Types.VARCHAR),
                    new ColumnInfo("REG_PATH_PARENT_ID", Types.INTEGER),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_PATH", pathColumns);
        }
        {
            List<ColumnInfo> contentColumns = Arrays.asList(
                    new ColumnInfo("REG_CONTENT_ID", Types.INTEGER),
                    new ColumnInfo("REG_CONTENT_DATA", Types.BLOB),  // Note: Using Types.BLOB for LONGBLOB
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_CONTENT", contentColumns);
        }
        {
            List<ColumnInfo> contentHistoryColumns = Arrays.asList(
                    new ColumnInfo("REG_CONTENT_ID", Types.INTEGER),
                    new ColumnInfo("REG_CONTENT_DATA", Types.BLOB),  // Note: Using Types.BLOB for LONGBLOB
                    new ColumnInfo("REG_DELETED", Types.SMALLINT),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_CONTENT_HISTORY", contentHistoryColumns);
        }
        {
            List<ColumnInfo> resourceColumns = Arrays.asList(
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_VERSION", Types.INTEGER),
                    new ColumnInfo("REG_MEDIA_TYPE", Types.VARCHAR),
                    new ColumnInfo("REG_CREATOR", Types.VARCHAR),
                    new ColumnInfo("REG_CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_LAST_UPDATOR", Types.VARCHAR),
                    new ColumnInfo("REG_LAST_UPDATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("REG_CONTENT_ID", Types.INTEGER),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("REG_UUID", Types.VARCHAR)
            );
            tableInfo.put("REG_RESOURCE", resourceColumns);
        }
        {
            List<ColumnInfo> resourceHistoryColumns = Arrays.asList(
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_VERSION", Types.INTEGER),
                    new ColumnInfo("REG_MEDIA_TYPE", Types.VARCHAR),
                    new ColumnInfo("REG_CREATOR", Types.VARCHAR),
                    new ColumnInfo("REG_CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_LAST_UPDATOR", Types.VARCHAR),
                    new ColumnInfo("REG_LAST_UPDATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("REG_CONTENT_ID", Types.INTEGER),
                    new ColumnInfo("REG_DELETED", Types.SMALLINT),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("REG_UUID", Types.VARCHAR)
            );
            tableInfo.put("REG_RESOURCE_HISTORY", resourceHistoryColumns);
        }
        {
            List<ColumnInfo> commentColumns = Arrays.asList(
                    new ColumnInfo("REG_ID", Types.INTEGER),
                    new ColumnInfo("REG_COMMENT_TEXT", Types.VARCHAR),
                    new ColumnInfo("REG_USER_ID", Types.VARCHAR),
                    new ColumnInfo("REG_COMMENTED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_COMMENT", commentColumns);
        }
        {
            List<ColumnInfo> resourceCommentColumns = Arrays.asList(
                    new ColumnInfo("REG_COMMENT_ID", Types.INTEGER),
                    new ColumnInfo("REG_VERSION", Types.INTEGER),
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_RESOURCE_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_RESOURCE_COMMENT", resourceCommentColumns);
        }
        {
            List<ColumnInfo> ratingColumns = Arrays.asList(
                    new ColumnInfo("REG_ID", Types.INTEGER),
                    new ColumnInfo("REG_RATING", Types.INTEGER),
                    new ColumnInfo("REG_USER_ID", Types.VARCHAR),
                    new ColumnInfo("REG_RATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_RATING", ratingColumns);
        }
        {
            List<ColumnInfo> resourceRatingColumns = Arrays.asList(
                    new ColumnInfo("REG_RATING_ID", Types.INTEGER),
                    new ColumnInfo("REG_VERSION", Types.INTEGER),
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_RESOURCE_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_RESOURCE_RATING", resourceRatingColumns);
        }
        {
            List<ColumnInfo> tagColumns = Arrays.asList(
                    new ColumnInfo("REG_ID", Types.INTEGER),
                    new ColumnInfo("REG_TAG_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_USER_ID", Types.VARCHAR),
                    new ColumnInfo("REG_TAGGED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_TAG", tagColumns);
        }
        {
            List<ColumnInfo> resourceTagColumns = Arrays.asList(
                    new ColumnInfo("REG_TAG_ID", Types.INTEGER),
                    new ColumnInfo("REG_VERSION", Types.INTEGER),
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_RESOURCE_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_RESOURCE_TAG", resourceTagColumns);
        }
        {
            List<ColumnInfo> propertyColumns = Arrays.asList(
                    new ColumnInfo("REG_ID", Types.INTEGER),
                    new ColumnInfo("REG_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_VALUE", Types.VARCHAR),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_PROPERTY", propertyColumns);
        }
        {
            List<ColumnInfo> resourcePropertyColumns = Arrays.asList(
                    new ColumnInfo("REG_PROPERTY_ID", Types.INTEGER),
                    new ColumnInfo("REG_VERSION", Types.INTEGER),
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_RESOURCE_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_RESOURCE_PROPERTY", resourcePropertyColumns);
        }
        {
            List<ColumnInfo> associationColumns = Arrays.asList(
                    new ColumnInfo("REG_ASSOCIATION_ID", Types.INTEGER),
                    new ColumnInfo("REG_SOURCEPATH", Types.VARCHAR),
                    new ColumnInfo("REG_TARGETPATH", Types.VARCHAR),
                    new ColumnInfo("REG_ASSOCIATION_TYPE", Types.VARCHAR),
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_ASSOCIATION", associationColumns);
        }
        {
            List<ColumnInfo> snapshotColumns = Arrays.asList(
                    new ColumnInfo("REG_SNAPSHOT_ID", Types.INTEGER),
                    new ColumnInfo("REG_PATH_ID", Types.INTEGER),
                    new ColumnInfo("REG_RESOURCE_NAME", Types.VARCHAR),
                    new ColumnInfo("REG_RESOURCE_VIDS", Types.BLOB),  // Using Types.BLOB for LONGBLOB
                    new ColumnInfo("REG_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("REG_SNAPSHOT", snapshotColumns);
        }
        {
            List<ColumnInfo> tenantColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_DOMAIN_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_EMAIL", Types.VARCHAR),
                    new ColumnInfo("UM_ACTIVE", Types.BOOLEAN),
                    new ColumnInfo("UM_CREATED_DATE", Types.TIMESTAMP),
                    new ColumnInfo("UM_USER_CONFIG", Types.BLOB)  // Using Types.BLOB for LONGBLOB
            );
            tableInfo.put("UM_TENANT", tenantColumns);
        }
        {
            List<ColumnInfo> domainColumns = Arrays.asList(
                    new ColumnInfo("UM_DOMAIN_ID", Types.INTEGER),
                    new ColumnInfo("UM_DOMAIN_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_DOMAIN", domainColumns);
        }
        {
            List<ColumnInfo> userColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_USER_PASSWORD", Types.VARCHAR),
                    new ColumnInfo("UM_SALT_VALUE", Types.VARCHAR),
                    new ColumnInfo("UM_REQUIRE_CHANGE", Types.BOOLEAN),
                    new ColumnInfo("UM_CHANGED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_USER", userColumns);
        }
        {
            List<ColumnInfo> systemUserColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_USER_PASSWORD", Types.VARCHAR),
                    new ColumnInfo("UM_SALT_VALUE", Types.VARCHAR),
                    new ColumnInfo("UM_REQUIRE_CHANGE", Types.BOOLEAN),
                    new ColumnInfo("UM_CHANGED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_SYSTEM_USER", systemUserColumns);
        }
        {
            List<ColumnInfo> userAttributeColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_ATTR_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_ATTR_VALUE", Types.VARCHAR),
                    new ColumnInfo("UM_PROFILE_ID", Types.VARCHAR),
                    new ColumnInfo("UM_USER_ID", Types.INTEGER),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_USER_ATTRIBUTE", userAttributeColumns);
        }
        {
            List<ColumnInfo> roleColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_ROLE_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("UM_SHARED_ROLE", Types.BOOLEAN)
            );
            tableInfo.put("UM_ROLE", roleColumns);
        }
        {
            List<ColumnInfo> moduleColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_MODULE_NAME", Types.VARCHAR)
            );
            tableInfo.put("UM_MODULE", moduleColumns);
        }
        {
            List<ColumnInfo> moduleActionColumns = Arrays.asList(
                    new ColumnInfo("UM_ACTION", Types.VARCHAR),
                    new ColumnInfo("UM_MODULE_ID", Types.INTEGER)
            );
            tableInfo.put("UM_MODULE_ACTIONS", moduleActionColumns);
        }
        {
            List<ColumnInfo> permissionColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_RESOURCE_ID", Types.VARCHAR),
                    new ColumnInfo("UM_ACTION", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("UM_MODULE_ID", Types.INTEGER)
            );
            tableInfo.put("UM_PERMISSION", permissionColumns);
        }
        {
            List<ColumnInfo> rolePermissionColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_PERMISSION_ID", Types.INTEGER),
                    new ColumnInfo("UM_ROLE_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_IS_ALLOWED", Types.SMALLINT),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("UM_DOMAIN_ID", Types.INTEGER)
            );
            tableInfo.put("UM_ROLE_PERMISSION", rolePermissionColumns);
        }
        {
            List<ColumnInfo> userPermissionColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_PERMISSION_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_IS_ALLOWED", Types.SMALLINT),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_USER_PERMISSION", userPermissionColumns);
        }
        {
            List<ColumnInfo> userRoleColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_ROLE_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_ID", Types.INTEGER),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_USER_ROLE", userRoleColumns);
        }
        {
            List<ColumnInfo> sharedUserRoleColumns = Arrays.asList(
                    new ColumnInfo("UM_ROLE_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("UM_ROLE_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_SHARED_USER_ROLE", sharedUserRoleColumns);
        }
        {
            List<ColumnInfo> accountMappingColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_STORE_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("UM_ACC_LINK_ID", Types.INTEGER)
            );
            tableInfo.put("UM_ACCOUNT_MAPPING", accountMappingColumns);
        }
        {
            List<ColumnInfo> dialectColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_DIALECT_URI", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_DIALECT", dialectColumns);
        }
        {
            List<ColumnInfo> claimColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_DIALECT_ID", Types.INTEGER),
                    new ColumnInfo("UM_CLAIM_URI", Types.VARCHAR),
                    new ColumnInfo("UM_DISPLAY_TAG", Types.VARCHAR),
                    new ColumnInfo("UM_DESCRIPTION", Types.VARCHAR),
                    new ColumnInfo("UM_MAPPED_ATTRIBUTE_DOMAIN", Types.VARCHAR),
                    new ColumnInfo("UM_MAPPED_ATTRIBUTE", Types.VARCHAR),
                    new ColumnInfo("UM_REG_EX", Types.VARCHAR),
                    new ColumnInfo("UM_SUPPORTED", Types.SMALLINT),
                    new ColumnInfo("UM_REQUIRED", Types.SMALLINT),
                    new ColumnInfo("UM_DISPLAY_ORDER", Types.INTEGER),
                    new ColumnInfo("UM_CHECKED_ATTRIBUTE", Types.SMALLINT),
                    new ColumnInfo("UM_READ_ONLY", Types.SMALLINT),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_CLAIM", claimColumns);
        }
        {
            List<ColumnInfo> profileConfigColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_DIALECT_ID", Types.INTEGER),
                    new ColumnInfo("UM_PROFILE_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_PROFILE_CONFIG", profileConfigColumns);
        }
        {
            List<ColumnInfo> hybridRoleColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_ROLE_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_HYBRID_ROLE", hybridRoleColumns);
        }
        {
            List<ColumnInfo> hybridUserRoleColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_ROLE_ID", Types.INTEGER),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER),
                    new ColumnInfo("UM_DOMAIN_ID", Types.INTEGER)
            );
            tableInfo.put("UM_HYBRID_USER_ROLE", hybridUserRoleColumns);
        }
        {
            List<ColumnInfo> hybridRememberMeColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_COOKIE_VALUE", Types.VARCHAR),
                    new ColumnInfo("UM_CREATED_TIME", Types.TIMESTAMP),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_HYBRID_REMEMBER_ME", hybridRememberMeColumns);
        }
        {
            List<ColumnInfo> systemRoleColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_ROLE_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_SYSTEM_ROLE", systemRoleColumns);
        }
        {
            List<ColumnInfo> systemUserRoleColumns = Arrays.asList(
                    new ColumnInfo("UM_ID", Types.INTEGER),
                    new ColumnInfo("UM_USER_NAME", Types.VARCHAR),
                    new ColumnInfo("UM_ROLE_ID", Types.INTEGER),
                    new ColumnInfo("UM_TENANT_ID", Types.INTEGER)
            );
            tableInfo.put("UM_SYSTEM_USER_ROLE", systemUserRoleColumns);
        }



        return tableInfo;
    }

}
