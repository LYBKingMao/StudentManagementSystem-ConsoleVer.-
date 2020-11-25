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
}
