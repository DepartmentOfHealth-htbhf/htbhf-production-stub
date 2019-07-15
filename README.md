# htbhf-production-stub
Service for stubbing out DWP and HMRC apis in production whilst in private beta.

## Benefit Eligibility Stubbing
During private beta, all eligible applications should be found in the database and no calls should be needed to the dwp/hmrc api.

If the user enter's in their details incorrectly, they will not be found in the database and our service will call the external DWP/HMRC apis, which currently do not exist.

For any valid request, the service will return with an eligibility status of NO_MATCH.
