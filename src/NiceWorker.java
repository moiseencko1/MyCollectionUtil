/**
 * Created by Acer on 23.10.2016.
 */
public class NiceWorker extends Worker {
    private boolean flag;

    public NiceWorker(String name, int salary, boolean flag) {
        super(name, salary);
        this.flag = flag;
    }
}
