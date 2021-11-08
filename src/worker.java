import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.Collections;
/*
Helpful Link(s):
    - https://www.baeldung.com/java-quicksort
Note2Self:
    - The textbook sucks, p = start_ind|r = end_ind
        ^ Why couldn't the book have just said this????
 */

public class worker {
    // file handler >> f_master
    void f_handler(ArrayList<Integer> ignored_data, ArrayList<Integer> data, String PATH) throws IOException {
        // whereWeAt message >> gives me a general feel where program is if there is an error
        System.out.print(">>> Reading File....");

        // create buffered reader for file handling >> should be faster than scanner?
        BufferedReader f_reader = Files.newBufferedReader(Paths.get(PATH));
        String line; // the fact that I need this boggles my mind; stores readLine for BFRead

        // add content to arraylist
        // ^ why does this read only half the file if not using 'line' var?
        while ((line = f_reader.readLine()) != null){
            data.add(Integer.parseInt(line));
            ignored_data.add(Integer.parseInt(line));

        }
        // success! if this failed I would have cried
        System.out.print("Done");
    }

    // quick sorter >> q_master
    void q_sort(ArrayList<Integer> array, int start_ind, int end_ind){
        if (start_ind < end_ind){
            // returns partition index; index where partition of array occurs?
            // partitions the array too
            int part_ind = q_part(array, start_ind, end_ind);

            // wait what >> ah, sets the indices (kinda get it)
            q_sort(array, start_ind, part_ind-1); // run sorter on first sub-list
            q_sort(array, part_ind+1, end_ind); // run sorter on last sub-list

        }
    }
            // partition given array >> q_slave1
            int q_part(ArrayList<Integer> array, int start_ind, int end_ind){
                // pivot: divides the array in two
                // sub-list1 < pivot < sublist2 (sublist elements follow this)
                // optimal pivot is middle of list?
                int pivot = array.get(end_ind);
                int i = start_ind - 1;

                // [loop] swap i and j if j <= pivot
                for(int j=start_ind; j < end_ind; j++){
                    if (array.get(j) <= pivot) {
                        // increment i; must be first since i == -1
                        i++;

                        // if arr[j] <= pivot swap the two
                        Collections.swap(array, i, j);
                    }
                }

                // WHY IS THIS HERE, HOW DOES THIS WORK?? AHHH
                // swaps element +1 to start_ind with end_ind
                // entire algorithm fails if this swap is disabled
                Collections.swap(array, i+1, end_ind);
                return i += 1;
            }
}
