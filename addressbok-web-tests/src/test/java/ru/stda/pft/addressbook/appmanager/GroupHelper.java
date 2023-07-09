package ru.stda.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stda.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void retuneToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCretion() {
        click(By.name("new"));
    }

    public void deleteSelectionGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }



    }

