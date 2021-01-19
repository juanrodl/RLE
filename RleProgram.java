import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class RleProgram {

    public static String toHexString(byte[] data){
        //Concatenates hexString based on value at each position in the array.
        String hexString = "";
        for (int i = 0; i < data.length; i++){
            if (data[i] == 1){
                hexString = hexString + "1";
            } else if (data[i] == 2){
                hexString = hexString + "2";
            } else if (data[i] == 3){
                hexString = hexString + "3";
            } else if (data[i] == 4){
                hexString = hexString + "4";
            } else if (data[i] == 5){
                hexString = hexString + "5";
            } else if (data[i] == 6){
                hexString = hexString + "6";
            } else if (data[i] == 7){
                hexString = hexString + "7";
            } else if (data[i] == 8){
                hexString = hexString + "8";
            } else if (data[i] == 9){
                hexString = hexString + "9";
            } else if (data[i] == 10){
                hexString = hexString + "a";
            } else if (data[i] == 11){
                hexString = hexString + "b";
            } else if (data[i] == 12){
                hexString = hexString + "c";
            } else if (data[i] == 13){
                hexString = hexString + "d";
            } else if (data[i] == 14){
                hexString = hexString + "e";
            } else if (data[i] == 15){
                hexString = hexString + "f";
            } else if (data[i] == 0){
                hexString = hexString + "0";
            }

        }
        return hexString;
            }

    public static int countRuns(byte[] flatData){
        //Runs through the entire array and checks every time consecutive numbers are not equal to each other and keeps a counter
        int count = 1;
        int rep = 1;
        for (int i = 0; i < flatData.length; i++){
            if (i + 1 < flatData.length && flatData[i] != flatData[i+1]){
                count++;
            } else {
                rep++;
                if (rep > 15){
                    count++;
                    rep = 1;
                }
            }
        }
        return count;

        }

        public static byte[] encodeRle(byte[] flatData) {

            ByteArrayOutputStream encodedRle = new ByteArrayOutputStream();

            // Runs through entire array and checks for consecutive numbers, once numbers are no longer consecutive, adds a counter to array and then adds the original consecutive number
            for (int i = 0; i < flatData.length; i++) {
                int count = 1;
                while (i + 1 < flatData.length && flatData[i] == flatData[i + 1]) {
                    count++;
                    i++;

                    if (count >= 15){
                        break;
                    }
                }

                encodedRle.write((byte)count);
                encodedRle.write(flatData[i]);
            }
            return encodedRle.toByteArray();
        }



        public static int getDecodedLength(byte[] rleData){
            //Runs through the entire array and adds every number in the array skipping one in between each element in the array.
            int length = 0;
            for (int i = 0; i < rleData.length; i++){
                if (i%2 == 0){
                    length = length + rleData[i];
                }
            }
            return length;
        }

        public static byte[] decodeRle(byte[] rleData){
            //Runs through entire array and checks the first element of the array and prints the second element of the array as many times as the value of the first element, repeated until array is over.
            ByteArrayOutputStream decodedRle = new ByteArrayOutputStream();

            for (int i = 1; i < rleData.length; i+=2){
                for (int j = 0; j < rleData[i - 1]; j++) {
                    decodedRle.write(rleData[i]);
                }
            }

        return decodedRle.toByteArray();
        }

        public static byte[] stringToData(String dataString){
            // Runs through every character of dataString and assigns its corresponding value to a position in a new array.
            byte[] rleArray = new byte[dataString.length()];
            for (int i = 0; i < dataString.length(); i++){
                if (dataString.charAt(i) == '0'){
                    rleArray[i] = 0;
                } else if (dataString.charAt(i) == '1'){
                    rleArray[i] = 1;
                } else if (dataString.charAt(i) == '2'){
                    rleArray[i] = 2;
                } else if (dataString.charAt(i) == '3'){
                    rleArray[i] = 3;
                } else if (dataString.charAt(i) == '4'){
                    rleArray[i] = 4;
                } else if (dataString.charAt(i) == '5'){
                    rleArray[i] = 5;
                } else if (dataString.charAt(i) == '6'){
                    rleArray[i] = 6;
                } else if (dataString.charAt(i) == '7'){
                    rleArray[i] = 7;
                } else if (dataString.charAt(i) == '8'){
                    rleArray[i] = 8;
                } else if (dataString.charAt(i) == '9'){
                    rleArray[i] = 9;
                } else if (dataString.charAt(i) == 'a'){
                    rleArray[i] = 10;
                } else if (dataString.charAt(i) == 'b'){
                    rleArray[i] = 11;
                } else if (dataString.charAt(i) == 'c'){
                    rleArray[i] = 12;
                } else if (dataString.charAt(i) == 'd'){
                    rleArray[i] = 13;
                } else if (dataString.charAt(i) == 'e'){
                    rleArray[i] = 14;
                } else if (dataString.charAt(i) == 'f'){
                    rleArray[i] = 15;
                }
            }

            return rleArray;
        }

        public static String toRleString(byte[] rleData){
            //Converts the second element in rleData to RLE and adds a colon
            String rleString = "";
            for (int i = 0; i < rleData.length; i++){
                if (rleData[i] == 1 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "1:";
                } else if (rleData[i] == 2 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "2:";
                } else if (rleData[i] == 3 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "3:";
                } else if (rleData[i] == 4 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "4:";
                } else if (rleData[i] == 5 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "5:";
                } else if (rleData[i] == 6 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "6:";
                } else if (rleData[i] == 7 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "7:";
                } else if (rleData[i] == 8 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "8:";
                } else if (rleData[i] == 9 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "9:";
                } else if (rleData[i] == 10 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "a:";
                } else if (rleData[i] == 11 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "b:";
                } else if (rleData[i] == 12 && (i -1 )%2 == 0){
                    rleString = rleString + rleData[i - 1] + "c:";
                } else if (rleData[i] == 13 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "d:";
                } else if (rleData[i] == 14 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "e:";
                } else if (rleData[i] == 15 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "f:";
                } else if (rleData[i] == 0 && (i - 1)%2 == 0){
                    rleString = rleString + rleData[i - 1] + "0:";
                }
            }
            //Removes last colon in rleString
            rleString = rleString.substring(0, rleString.length() - 1);

            return rleString;
        }

    public static byte[] stringToRle(String rleString) {
        //Splits up rleString everywhere there is a ':' and stores them in an array
        String[] splitStrings = rleString.split(":");
        byte[] rleArray = new byte[2 * splitStrings.length];
        char c;

        for (int i = 0; i < splitStrings.length; i++) {
            //Converts splitStrings string into byte
            rleArray[2 * i] = Byte.parseByte(splitStrings[i].substring(0, splitStrings[i].length() - 1));
            c = splitStrings[i].charAt(splitStrings[i].length() - 1);

            if (c <= '9') {
                rleArray[2 * i + 1] = (byte) (c - '0');
            } else {
                rleArray[2 * i + 1] = (byte) (10 + (c - 'a'));
            }
        }

        return rleArray;
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 1;
        String fileName, data = null;
        String[] temp = null;
        // 1. Display welcome message
        System.out.println("Welcome to the RLE image encoder!");

        // 2. Display color test with the message
        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);

        byte[] imageData = null;

        // 3. Display the menu - Part A: while loop or if-else chains
        while (true) {
            System.out.println("RLE Menu");
            System.out.println("--------");
            System.out.println("0. Exit");
            System.out.println("1. Load File");
            System.out.println("2. Load Test Image");
            System.out.println("3. Read RLE String");
            System.out.println("4. Read RLE Hex String");
            System.out.println("5. Read Data Hex String");
            System.out.println("6. Display Image");
            System.out.println("7. Display RLE String");
            System.out.println("8. Display Hex RLE Data");
            System.out.println("9. Display Hex Flat Data");
            System.out.print("Select a Menu Option: ");
            option = in.nextInt();

            // 3.1 - option 1
            // ConsoleGfx.loadFile(userInput) and you want to store the returned byte[] into imageData array
            if (option == 1) {
                System.out.println("Enter name of file to load: ");
                fileName = in.next();
                imageData = ConsoleGfx.loadFile(fileName);
                // 3.2 - option 2
                // store ConsoleGfx.testImage into the imageData array
            } else if (option == 2) {
                imageData = ConsoleGfx.testImage;
                System.out.println("Test image data loaded.");
                // 3.6 - option 6
                // display image stored inside of imageData array
            } else if (option == 3) {
                System.out.println("Enter an RLE string to be decoded: ");
                data = in.next();
                imageData = stringToRle(data);
            } else if (option == 4) {
                System.out.println("Enter the hex string holding RLE data: ");
                data = in.next();
                imageData = stringToData(data);
            } else if (option == 5) {
                System.out.println("Enter the hex string holding flat data: ");
                data = in.next();
                imageData = stringToData(data);
            } else if (option == 6) {
                System.out.print("Displaying image...");
                ConsoleGfx.displayImage(imageData);
            } else if (option == 7) {
                System.out.println("RLE representation: " + toRleString(imageData));
            } else if (option == 8) {
                String s = toRleString(imageData);
                System.out.println("RLE hex values : " + s.replaceAll(":",""));
            } else if (option == 9) {
                System.out.println("Flat hex values: " + toHexString((decodeRle(imageData))));
            } else if (option == 0){
                break;
            }
            else
                System.out.println("Error! Invalid input.");
        }
    }
}
