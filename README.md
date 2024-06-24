# android-exam

## Known Issues
1. **Bug in Pagination Feature**:
   - **Description**: Pagination is adding all the fetched data in first initial load to the loadmore fetched data
   - **Description**: onscroll listener loads the fetching of data many more times when the data is actually loaded
   - **Description**: Swipe refresh triggers onscroll listener of of the adapter view
   - **Observation**: Currently, endless scrolling works, but the data fetched are duplicated at first and unstable adding of data is observed in adapter.
   - **Steps Taken**: I have debugged this using the debug of android studio, and showing some logs to check the flow of the code specially in onscroll of scroll listener
   - **Potential Solution**: I would have refactored the MainActivityViewModel, RandomPersonRepositor, yPersonAdapter and RetrofitInstace to add the Paging Library of Android Jetpack  

## Goal of the exam ##
To assess a developer's skills in terms of developing Android apps and decision-making on solving common development tasks.

## Tasks ##

- Fork this repository
- Create an Android project with the following features:
    - Create User Interfaces with XML in android
    - Loads and shows a list of Persons from a remote source(can be from some random source / https://randomuser.me)
    - Caches the loaded list of Persons
    - Prevents any loading from the remote source if the cache is available
    - Shows the full details of a Person on a separate screen
    - Swipe to refresh (Force update the cache data)
    - Loading more data when scrolling down bottom.
    - Each `Person` must have the following data: or use the API data https://randomuser.me
        - First name
        - Last name
        - Birthday
        - Age (derived from Birthday)
        - Email address
        - Mobile number
        - Address
        - Contact person
        - Contact person's phone number
    - Uses Clean Architecture
    - Uses Modularization 

- Exam Strategy
    - Start with a Basic Skeleton
    - Implement Core Features
    - Detail Screen and Navigation
    - Additional Features
      - Swipe to refresh
      - Pagination
    - Testing and Material Design
    - Git and Documentation
- Ensure all requirements are met and send an email to arjay.paulino@cybilltek.com once done.

Any libraries or tools of the developer's choosing may be used.

## Optional requirements ##

- Changes are committed following Git Flow
- Follows [this guideline](https://github.com/ribot/android-guidelines)
- Unit tests
- UI tests
- Material design
- Has proguard enabled
- Respects Activity/Fragment lifecycle
- `Mock` flavour that uses mock web server and doesn't have a `release` variant
- `Prod` flavour that uses a random remote source and doesn't have a `debug` variant
- Uses Model-View-ViewModel or similar design pattern
- Uses the Observable pattern
- Uses Dependency Injection
- Uses RxJava
