package leetcode;

import java.util.HashMap;
import java.util.TreeSet;

//["FoodRatings","highestRated","highestRated","changeRating","highestRated","changeRating","highestRated"]
//        [[["kimchi","miso","sushi","moussaka","ramen","bulgogi"],
//        ["korean","japanese","japanese","greek","japanese","korean"],
//        [9,12,8,15,14,7]],["korean"],["japanese"],["sushi",16],["japanese"],["ramen",16],["japanese"]]
public class FoodRatings {
    public static void main(String[] args) {
        var fr=new FoodRatings(new String[]{"kimchi","miso","sushi","moussaka","ramen","bulgogi"},
                new String[]{"korean","japanese","japanese","greek","japanese","korean"},
                new int[]{9,12,8,15,14,7});
        fr.changeRating("sushi",16);
        fr.changeRating("ramen",16);
        System.out.println(fr.highestRated("japanese"));
    }
    HashMap<String, TreeSet<Food>> m=new HashMap<>();
    HashMap<String, Food> fr=new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++) {
            TreeSet<Food> f=m.computeIfAbsent(cuisines[i], k->new TreeSet<>());
            Food food=new Food(cuisines[i], foods[i], ratings[i]);
            f.add(food);
            fr.put(foods[i], food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f=fr.get(food);

        var cs=m.get(f.cuisine);
        cs.remove(f);
        f.r=newRating;
        cs.add(f);
    }

    public String highestRated(String cuisine) {
        return m.get(cuisine).first().food;
    }

    private static class Food implements Comparable<Food> {
        String cuisine;
        String food;
        int r;

        public Food(String cuisine, String food, int r) {
            this.cuisine = cuisine;
            this.food=food;
            this.r = r;
        }

        @Override
        public int compareTo(Food o) {
            return r!=o.r?-Integer.compare(r,o.r):food.compareTo(o.food);
        }
    }
}
