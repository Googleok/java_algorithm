package java_code.thread;

public class RamenProgram {
    public static void main(String[] args) {
        try {
            RamenCook ramenCook = new RamenCook(Integer.parseInt("50"));
            new Thread(ramenCook, "A").start();
            new Thread(ramenCook, "B").start();
            new Thread(ramenCook, "C").start();
            new Thread(ramenCook, "D").start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RamenCook implements Runnable {

    private int ramenCount;
    private String[] burners = {"_", "_", "_", "_"};

    public RamenCook(int count) {
        this.ramenCount = count;
    }

    @Override
    public void run() {
        while (ramenCount > 0) {
            synchronized (this) {
                ramenCount--;
                System.out.println(
                        Thread.currentThread().getName()
                                + ": " + ramenCount + "개 남음"
                );
            }

            for (int i = 0; i < burners.length; i++) {
                if (!burners[i].equals("_")) continue;

                synchronized (this) {
                    burners[i] = Thread.currentThread().getName();
                    System.out.println(
                            "        "
                                    + Thread.currentThread().getName()
                                    + ": [" + (i + 1) + "]번 버너 ON"
                    );
                    showBurners();
                }

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (this) {
                    burners[i] = "_";
                    System.out.println(
                            "                    "
                                    + Thread.currentThread().getName()
                                    + ": [" + (i + 1) + "]번 버너 OFF"
                    );
                    showBurners();
                }
                break;
            }

            try {
                Thread.sleep(Math.round(1000 * Math.random()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showBurners() {
        StringBuilder stringToPrint = new StringBuilder("                             ");
        for (String burner : burners) {
            stringToPrint.append(" ").append(burner);
        }
        System.out.println(stringToPrint.toString());
    }
}



