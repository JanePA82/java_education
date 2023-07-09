package ru.stda.pft.addressbook;

import org.testng.annotations.Test;

public class DeleteGroupTests extends  TestBase{


    @Test
    public void testDeleteGroupTests() throws Exception {
        gotoGroupPage();
        selectGroup();
        deleteSelectionGroup();
        retuneToGroupPage();
    }

}
