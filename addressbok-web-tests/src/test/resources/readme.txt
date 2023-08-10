$\java_education\addressbok-web-tests>gradlew testContacts

gradlew- команда
testContacts - название в таске из build.gradle
task testContacts(type: Test) {
    useTestNG { suites 'src/test/resources/testng-contact.xml' }
}