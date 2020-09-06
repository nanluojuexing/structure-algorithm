package structure.skip;

import org.junit.Test;

public class SkipListTest {

    @Test
    public void testSkipList() {
        SkipList_2 skipList = new SkipList_2();
        for (int i = 1; i <= 5; i++) {
            skipList.insert(i);
        }
        System.out.println(skipList);

        SkipList_2.Node node = skipList.find(11);
        if (node != null) {
            System.out.println(node);
        } else {
            System.out.println("not found");
        }

//        skipList.delete(11);
//        System.out.println(skipList);
//
//        node = skipList.find(11);
//        if (node != null) {
//            System.out.println(node);
//        } else {
//            System.out.println("not found");
//        }

    }
}
