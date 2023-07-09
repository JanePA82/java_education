package ru.stda.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroupTests extends  TestBase{


    @Test
    public void testDeleteGroupTests() throws Exception {
        app.gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectionGroup();
        app.getGroupHelper().retuneToGroupPage();
    }

}
