$\java_education\addressbok-web-tests>gradlew testContacts

gradlew- �������
testContacts - �������� � ����� �� build.gradle
task testContacts(type: Test) {
    useTestNG { suites 'src/test/resources/testng-contact.xml' }
}