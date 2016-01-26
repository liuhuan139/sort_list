package Util;

import Model.Model;

import java.util.*;

/**
 * Created by liuhuan on 16-1-23.
 */
public class ModelUtils {
    public static final String MODEL_DATE = "model_time";
    public static final String MODEL_MONEY = "model_money";

    /**
     * the first method to sort ArrayList
     * @param models-model in the list
     * @param sortBy-the thing which the lits sort by
     * @return sorted list
     */
    public static List<Model> sortModel(List<Model> models ,String sortBy){
        if(models == null || models.size() < 1){
            return null;
        }
        List<Model> result_ls = new ArrayList<Model>();
        List<Integer> key_ls = new ArrayList<Integer>();
        Map<Integer,Model> sortMap = new HashMap<Integer,Model>();

        for(Model model : models) {
            switch (sortBy){
                case MODEL_DATE:
                    int date = model.dateTime;
                    sortMap.put(date,model);
                    key_ls.add(date);
                    break;
                case MODEL_MONEY:
                    int money = model.money;
                    sortMap.put(money,model);
                    key_ls.add(money);
                    break;
            }
        }

        Collections.sort(key_ls);
        for(Integer key_int : key_ls){
            result_ls.add(sortMap.get(key_int));
        }
        return result_ls;
    }






    /**
     * the second method to sort ArrayList
     * @param models-model in the list
     * @param sortBy-the thing which the lits sort by
     * @return sorted list
     */
    public static void sortModel2(List<Model> models ,String sortBy) {
       Collections.sort(models,MyComparator.getInstance(sortBy));
    }

    private static class MyComparator implements Comparator<Model>{
        private String sortBy;
        private static MyComparator mComparator;
        private MyComparator(String sortBy){
            this.sortBy = sortBy;
        }
        public static MyComparator getInstance(String sortBy){
            if(mComparator == null){
                mComparator = new MyComparator(sortBy);
            }
            return mComparator;
        }

        @Override
        public int compare(Model m1, Model m2) {
            int result = 0;
            switch (sortBy){
                case MODEL_DATE:
                    result = compare(m1.dateTime,m2.dateTime);
                    break;
                case MODEL_MONEY:
                    result = compare(m1.money,m2.money);
                    break;
            }
            return result;
        }

        private int compare(int c1, int c2) {
            if(c1 >c2){
                return 1;
            }else if(c1 < c2){
                return -1;
            }else {
                return 0;
            }
        }
    }

}
