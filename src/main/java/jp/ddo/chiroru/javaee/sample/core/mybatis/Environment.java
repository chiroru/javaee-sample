package jp.ddo.chiroru.javaee.sample.core.mybatis;

public enum Environment {

    UnitTest("UnitTest");
    
    private String myBatisEnvironment;
    
    private Environment(String myBatisEnvironment) {
        this.myBatisEnvironment = myBatisEnvironment;
    }
    
    public String getMyBatisEnvironment() {
        return myBatisEnvironment;
    }
}
