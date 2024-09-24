Create Keycloak client id and put these creds into application-prod.properties
Create eugene-realm in Keycloak with ROLE_PLAYER and ROLE_MANAGER and several users with passwords and emails
Request JWT token from http://localhost:8080/realms/eugene-realm/protocol/openid-connect/token
and use every request to the Rating service
