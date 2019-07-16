# htbhf-production-stub
Service for stubbing out DWP and HMRC apis in production whilst in private beta.

## Benefit Eligibility Stubbing
During private beta, all eligible applications should be found in the database and no calls should be needed to the dwp/hmrc api.

If the user enter's in their details incorrectly, they will not be found in the database and our service will call the external DWP/HMRC apis, which currently do not exist.

For any valid request, the service will return with an eligibility status of NO_MATCH.

## Deployment
To deploy, first login to the production space using `cf login`

Then run `cf push -p build/libs/htbhf-production-stub-0.0.1.jar` from the project's root directory (the app version is in [build.gradle](build.gradle) and will not change when built).

If the app is being deployed for the first time, you'll need to scale the application and create a route for it following the instructions below.

## Scaling the application
By default there will only be one instance of the application deployed. To change this to two instances, run the following command

`cf scale htbhf-production-stub -i 2`

## Creating a route

The app is now deployed but with no public route. To create a random route for the app you must run:
1. `export ROUTE=$(cat /dev/urandom | tr -dc 'a-z' | fold -w 16 | head -n 1)`
2. `cf map-route htbhf-production-stub london.cloudapps.digital --hostname ${ROUTE}`

To see the name of the public route, run  `echo ${ROUTE}.london.cloudapps.digital`
If you forget to save the route name, you can look up the routes using `cf routes`
