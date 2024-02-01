
public class Product {

    private String productName ;
    private int productCode ;

    private double unitCost;

    private boolean inCurrentProductLine;
    public Product(String productName, int productCode, double unitCost, boolean inCurrentProductLine) {
       this.productName = productName;
       this.productCode = productCode;
       this.unitCost = unitCost;
    }

    public String getProductName(){
        return productName;
    }


    public double getUnitCost(){
        return unitCost;
    }

    public int getProductCode() {
        return productCode;
    }


    public boolean isInCurrentProductLine() {
        return inCurrentProductLine;
    }

    public void setProductCode(int productCode) {
            this.productCode = productCode;
    }

    public void setProductName(String productName) {
            this.productName = productName;
    }

    public void setUnitCost(double unitCost) {
            this.unitCost = unitCost;
    }

    public void setInCurrentProductLine(boolean inCurrentProductLine) {
        this.inCurrentProductLine = inCurrentProductLine;
    }

    public String toString()

    {
        return "TO DO WRITE TOSTRING";
    }

}
