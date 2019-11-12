# htbhf-production-stub
Service for stubbing out DWP and HMRC apis in production whilst in private beta.

## Benefit Eligibility Stubbing
During private beta, all eligible applications should be found in the database and no calls should be needed to the dwp/hmrc api.

If the user enter's in their details incorrectly, they will not be found in the database and our service will call the external DWP/HMRC apis, which currently do not exist.

## DWP Version 1 endpoint
For any request to the endpoint `v1/dwp/benefits`, the service will return:
```
{
    "eligibilityStatus": "NO_MATCH"
}
```

## DWP Version 2 endpoint
For any request to the endpoint `/v2/dwp/benefits`, the service will return;
```
{
    "eligibilityStatus": "not_set",
    "deathVerificationFlag": "n/a",
    "mobilePhoneMatch": "not_set",
    "emailAddressMatch": "not_set",
    "addressLine1Match": "not_set",
    "postcodeMatch": "not_set",
    "pregnantChildDOBMatch": "not_set",
    "qualifyingBenefits": "not_set",
    "householdIdentifier": "",
    "dobOfChildrenUnder4": [],
    "identityStatus": "not_matched"
}
```
