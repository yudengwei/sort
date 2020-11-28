import bubble.Bubble;
import select.Select;
import sort.Sort;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        int[] argv = getData(1000000);
       // sort(Bubble.class.getSimpleName(), new Bubble(), argv);
        sort(Select.class.getSimpleName(), new Select(), argv);
    }

    private static void sort(String name, Sort sort, int[] args) {
        new SortThread(name,args,sort).start();
    }

    private static int[] getData(int length) {
        int[] args = new int[length];
        Random random = new Random();
        for (int i = 0; i< length; i++) {
            int num = random.nextInt(length);
            args[i] = num;
        }
        return args;
    }

    public static class SortThread extends Thread{

        public int[] args;
        private Sort sort;

        public SortThread(String name, int[] args, Sort sort) {
            super(name);
            this.args = args;
            this.sort = sort;
        }

        @Override
        public void run() {
            int[] argv = copy(args);
            System.out.println("--------start---------"+getName()+"---------");
            long start = System.currentTimeMillis();
            sort.sort(argv);
            long i = System.currentTimeMillis() - start;
            System.out.println("---------end: "+i+"------"+getName()+"---------");
            //println(argv);
        }

        private int[] copy(int[] args) {
            int[] argv = new int[args.length];
            System.arraycopy(args, 0, argv, 0, args.length);
            return argv;
        }

        private void println(int[] args) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i< args.length; i++) {
                if (i == 0) {
                    sb.append("[");
                }
                sb.append(args[i]);
                if (i != args.length -1) {
                    sb.append(",");
                } else {
                    sb.append("]");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
