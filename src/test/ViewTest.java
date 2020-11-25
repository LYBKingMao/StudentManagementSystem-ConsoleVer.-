import bean.User;
import org.junit.Test;
import view.View;

public class ViewTest {
    @Test
    public void indexViewTest(){
        User user = View.indexView();
        System.out.println(user.toString());
    }

    @Test
    public void managerViewTest(){
        int choice = View.managerMenuView();
        System.out.println(choice);
    }

    @Test
    public void addMenuTest(){
        User user = View.addMenuView();
        System.out.println(user.toString());
    }

    @Test
    public void deleteMenuTest(){
        String deleted = View.deleteMenuView();
        System.out.println(deleted);
    }

    @Test
    public void updateMenuTest(){
        User user = View.updateMenuView();
        System.out.println(user.toString());
    }

    @Test
    public void selectMenuTest(){
        String selected = View.selectMenuView();
        System.out.println(selected);
    }
}
