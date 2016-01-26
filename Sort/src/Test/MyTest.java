package Test;

import Model.Model;
import Util.ModelUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhuan on 16-1-23.
 */
public class MyTest {
    public static void main(String args[]){
        Model model1 = new Model(10,5000);
        Model model2 = new Model(20,8000);
        Model model3 = new Model(15,7000);
        List<Model> models = new ArrayList<Model>();
        models.add(model1);
        models.add(model2);
        models.add(model3);
        /* test1
        List<Model> sortedModel = ModelUtils.sortModel(models, ModelUtils.MODEL_DATE);
        for(Model model : sortedModel){
            System.out.println(model.dateTime);

        }
        */
        ModelUtils.sortModel2(models,ModelUtils.MODEL_MONEY);
        for(Model model : models){
            System.out.println(model.money);

        }

    }
}
