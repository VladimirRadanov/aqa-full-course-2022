package bdd;

import io.cucumber.java.AfterAll;
import main.util.DataHolder;

public abstract class BaseStep {

  protected DataHolder dataHolder = DataHolder.getInstance();

}
