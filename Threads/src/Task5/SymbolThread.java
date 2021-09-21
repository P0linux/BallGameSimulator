package Task5;

public class SymbolThread extends Thread{

    private char symbol;
    private static final int symbolCount = 20;

    public SymbolThread(char symbol){
        this.symbol = symbol;
    }

    @Override
    public void run(){
        for (int i = 0; i < 50; i++){
            for (int j =0; j < symbolCount; j++){
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
