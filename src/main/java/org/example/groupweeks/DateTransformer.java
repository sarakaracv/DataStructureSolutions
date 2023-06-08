package org.example.groupweeks;
import javax.imageio.IIOException;
import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateTransformer {



        public static List<String> transformDates(List<String> inputDates) {
            List<String> outputDates = new ArrayList<>();
            DateTimeFormatter inputFormatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter inputFormatter2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter inputFormatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            for (String inputDate : inputDates) {
                LocalDate date;
                try {
                    date = LocalDate.parse(inputDate, inputFormatter1);
                } catch (Exception e1) {
                    try {
                        date = LocalDate.parse(inputDate, inputFormatter2);
                    } catch (Exception e2) {
                        try {
                            date = LocalDate.parse(inputDate, inputFormatter3);
                        } catch (Exception e3) {
                            continue; // ignore invalid input dates
                        }
                    }
                }
                outputDates.add(date.format(outputFormatter));
            }

            return outputDates;
        }
        public static List<String > transformDates1(List<String> dates){
            throw new UnsupportedOperationException("Not Implemented. ");
        }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int datesCount=Integer.parseInt(bufferedReader.readLine().trim());
        List<String> dates= IntStream.range(0,datesCount).mapToObj(i->{
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
       // List<String > result= Result.transformDates1(dates);

    }
    }

