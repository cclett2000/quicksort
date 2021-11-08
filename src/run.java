import java.io.IOException;
import java.text.DecimalFormat;

/* Charles Lett Jr.
 * November 6, 2021
 * Desc: Implementation of the quick-sort algorithm
 * ^ also messing around with OOP trying to gain a better
 *   understanding of it (in Java);
 */

public class run {
    public static void main(String[] args) throws IOException {
        // init objects
        DecimalFormat f = new DecimalFormat("#.00");
        variable var = new variable();
        worker wrk = new worker();

        //start runtime
        long run_t_start = System.currentTimeMillis();

            // prepare file
            wrk.f_handler(var.tmp_dat, var.data, var.PATH);

            // run sorter
            System.out.print("\n\n>>> Sorting....");
            wrk.q_sort(var.data, var.start_ind, var.data.size() - 1);
            System.out.print("Done");
                // arrayCompare messages
                System.out.print("\n\tArray Before QuickSort: " + var.tmp_dat);
                System.out.print("\n\tArray After QuickSort:  " + var.data);

        // end runtime
        long run_t_end = System.currentTimeMillis();

            System.out.print("\n\n>>> Runtime: " + (run_t_end - run_t_start) + " ms");
            // this can't be right >> total mem = total allocated memory
            //                     >> free mem = derp (amount of allocated memory available)
            double used_mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.print("\n\tMemory Usage: " + f.format(used_mem/Math.pow(10, 6)) + " MB");
    }
}
