



import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.awt.desktop.*;


/*---------------LINKED-LIST-------------------*/
class linkedList{
    static Node head;
    static Node tail;

    static String value="";
    static String value2="";

    static Node head2;
    static Node tail2;
    public static int lineUsed = 0;

    /*---------Defining Node----------*/
    static class Node{
        String data;
         Node next;
         Node prev;

        public Node(String data){
            this.data= data;
            this.prev = null;
            this.next = null;
        }
    }
    /*------------------------->INSERTION<--------------------------*/
    /*----------Adding Data At HEAD----------*/
    public void addDataAtHead(String data){
        Node node = new Node(data);
        if(head==null ){
            head = node;
            tail = node;
            node.prev = null;
            lineUsed+=1;
            return;
        }
        Node curNode = tail;
        curNode.next = node;
        node.prev = curNode;
        tail = node;
        lineUsed+=1;
    }

    /*----------Adding Data At TAIL----------*/
//    public void addDataToTail(String data){
//        Node node  = new Node(data);
//        Node newNode = tail;
//        newNode.next = node;
//        node.prev = newNode;
//        tail = node;
//        lineUsed+=1;
//    }
    /*----------Adding Data in a given LINE----------*/
//    public void addDataInGivenLine(String data, int lineNo){
//        if(head==null) {
//            Node headNode = new Node("");
//            head = headNode;
//            tail = headNode;
//            headNode.prev = null;
//            lineUsed++;
////            lineNo--;
//        }
//        Node curNode = tail;
//        while(lineUsed!=lineNo){
//            Node newNode = new Node("");
//            curNode.next = newNode;
//            newNode.prev = curNode;
//            curNode = newNode;
//            lineUsed+=1;
//        }
//        tail = curNode;
//        curNode.data = data;
//    }
    /*----------Adding Data in the MIDDLE----------*/
//    public void addDataInMiddle(String data, int lineNo){
//        int count=1;
//        Node curNode = head;
//        while(count!=lineNo){
//            curNode = curNode.next;
//            count++;
//        }
//        curNode.data = data;
//    }
    /*------------------------->END<--------------------------*/

    /*------------------------->DELETION<--------------------------*/
    /*----------Deleting given LINE----------*/
    public void deleteGivenLine(int lineNo){
        if(head==null || lineNo>lineUsed || lineNo<0){
            System.out.println("NO DATA TO DELETE");
            return;
        }
        if(head.next==null){
            value = head.data;
            head=null;
            tail=null;
            lineUsed-=1;
            return;
        }
        if(lineNo==1 && head.next!=null){
            Node curNode = head;
            value = curNode.data;
            head =curNode.next;
            curNode = curNode.next;
            curNode.prev = null;
            lineUsed-=1;
            return;
        }
        Node curNode = head;
        int count =1;
        while(count!=lineNo){
            curNode=curNode.next;
            count++;
        }
        value = curNode.data;

            Node prev = curNode.prev;
            prev.next = curNode.next;
            if(curNode.next!=null){
            curNode.next.prev = prev;
            }else{
                tail = prev;
            }
            lineUsed--;
    }

    /*----------Deleting given LINE----------*/
    public void deleteEntireData() {
        if (head == null) {
            System.out.println("NO DATA TO DELETE");
            return;
        }
        Node curNode = head;
        if (head2 == null) {
            head2 = curNode;
        }

        Node duplicate = null;
        while (curNode != null) {
            duplicate = new Node("");
            duplicate.data = curNode.data;
            curNode = curNode.next;
        }
        tail2 = duplicate;
        head = null;
        tail = null;
        lineUsed = 0;
    }
    /*------------------------->END<--------------------------*/

    /*------------------------->UPDATE<--------------------------*/
    /*----------Update LINE----------*/
    public void updateLine(String data, int lineNo){

        if(head==null || lineNo>lineUsed || lineNo<=0){
            System.out.println("NO DATA TO UPDATE");
            return;
        }
        int count=1;
        Node curNode = head;
        while(count!=lineNo){
            curNode = curNode.next;
            count++;
        }
        value = curNode.data;
        System.out.println(value);
        curNode.data = data;

    }

    public void updateLine2(String data, String data2){
        if(head==null){
            System.out.println("NO DATA TO UPDATE");
            return;
        }
        Node curNode = head;
        String sentence ="";
        while(curNode!=null){
            sentence = curNode.data;
            if(Objects.equals(sentence, data)){
                curNode.data = data2;
            }
            curNode = curNode.next;

        }

    }
    /*----------Update WORD----------*/
    public void updateWord(String word1,String word2){
        value = word1;
        value2 = word2;
        String data="";
        if(head==null){
            System.out.println("NO DATA TO UPDATE");
            return;
        }
//        int count=1;
        Node curNode = head;
        while(curNode!=null) {

            data = curNode.data;
            int startPointer = 0;
            String finalS = "";
            String word = "";
            for (int i = 0; i < data.length(); i++) {
                word = "";
                if (data.charAt(i) == ' ' || i == data.length() - 1) {
                    if (i == data.length() - 1) {
                        i++;
                    }
                    for (int j = startPointer; j < i; j++) {
                        word += data.charAt(j);
                    }
                    if (word.equals(word1)) {
                        finalS += word2;

                    }

                    else {
                        finalS += word;

                    }
//                    System.out.println(i);
                    if(i!=data.length()){
                        finalS+=" ";
                    }
                    startPointer = i + 1;
                }
            }
            curNode.data = finalS;

            curNode = curNode.next;
        }
    }
    /*------------------------->END<--------------------------*/

    /*------------------------->SEARCHING<--------------------------*/
    /*----------SEARCH BY LINE----------*/
    public void searchByLine(String data){
        System.out.println(">-------------------------<");

        if(head==null){
            System.out.println("NO DATA TO SEARCH");
            return;
        }
        int count=1;
        Node curNode = head;
        while(curNode!=null){
            if(curNode.data.equals(data)){
                System.out.println("In Line number: "+count);
            }
            curNode = curNode.next;
            count++;
        }
        System.out.println(">-------------------------<");
    }

    /*----------SEARCH BY WORD----------*/
    public void searchByWord(String data){
        System.out.println(">-------------------------<");
        if(head==null){
            System.out.println("NO DATA TO SEARCH");
            return;
        }
        int check=0;
        Node curNode = head;
        int count=1;
        String sentence="";
        while(curNode!=null){
            sentence = curNode.data;
            check= findWord(sentence, data);
            if(check>-1){
                System.out.println("In Line Number: "+count+", "+"Starting from Position "+check);
            }
            curNode = curNode.next;
            count++;
        }
        System.out.println(">-------------------------<");
    }
    public int findWord(String data, String checkWord){
        int startPointer = 0;
        int position = -1;
        checkWord = checkWord.toLowerCase();
        int check = 0;
        String word = "";
        for(int i=0;i<data.length();i++){
            word="";

            if(data.charAt(i)==' ' || i==data.length()-1){
                if(i==data.length()-1){
                    i++;
                }
                for(int j=startPointer;j<i;j++){
                    word+=data.charAt(j);
                }
                word = word.toLowerCase();
                if(word.equals(checkWord)){
                    position = startPointer;
//                    check = 1;
                    break;
                }
                startPointer = i+1;
            }

        }
        return position;
    }
    /*------------------------->END<--------------------------*/

    /*------------------------->END<--------------------------*/
    /*----------Append Data----------*/
    public void appendData(String data, int lineNo){
        if(head==null || lineNo>lineUsed || lineNo<0){
            System.out.println("NO DATA FOUND");
            return;
        }
        Node curNode =head;
        int count = 1;

        while(count!=lineNo){
            curNode = curNode.next;
            count++;
        }
        String sentence = curNode.data;
        value = String.valueOf(sentence.length()-1);

        sentence+=" ";
        sentence+=data;
        curNode.data = sentence;


    }
    /*------------------------->END<--------------------------*/

    /*----------Printing Data----------*/

    public  void printData(){
        System.out.println(">-------------------------<");
        if(head==null){
            System.out.println("--No Data to Print--");
            System.out.println(">-------------------------<");
            return;
        }
        int count =1;
        Node curNode = head;
        while(curNode!=null){
            System.out.println(count+"."+" "+curNode.data);
            count++;
            curNode = curNode.next;
        }
        System.out.println(">-------------------------<");

    }
    public int size(){
        if(head==null){
            return 0;
        }
        Node curNode= head;
        int size=1;
        while(curNode!=null){
            size++;
            curNode=curNode.next;
        }
        return size;
    }
    /*------------------------->END<--------------------------*/

//    public  void  RevPrint(){
//        if(head==null){
//            System.out.println("null");
//            return;
//        }
//        Node redo = tail;
//
//        while(redo!=null){
//            System.out.print(redo.data+"->");
//            redo = redo.prev;
//        }
//        System.out.print("null");
//    }
}

/*---------------S-T-A-C-K-------------------*/
 class stack{
    private  node head;
    static class node{
        private int data;
        private node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public  boolean isEmpty(){
        return head == null;
    }
    public  void push(int data){
        node newNode = new node(data);
        if(isEmpty()){
            head =newNode;
            return;
        }
        newNode.next =head;
        head = newNode;
    }
    public  int pop(){

        if(isEmpty()){
            return -1;
        }
        int top =  head.data;
        head = head.next;
        return top;
    }
    public  int peek(){
        if(isEmpty()){
            return -1;
        }
        int top= head.data;
        return top;
    }
    public  void print(){
        if(isEmpty()){
            System.out.println("NO DATA TO PRINT-----STACK");
            return;
        }
        node curNode =head;
        while(curNode!=null){
            System.out.println(curNode.data);
            curNode =curNode.next;
        }
    }

}
/*-------------E-N-D-------------*/
class textEditor extends linkedList {
    public static int input(){
        Scanner scan= new Scanner(System.in);
        int selection  = scan.nextInt();
        return selection;
    }
    public static String input1(){
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        return data;
    }
    /*------Main Function------*/
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        stack undo = new stack();
        stack redo = new stack();
        ArrayList<String> arr = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> fileList = new ArrayList<>();
        String curFile ="";
        while(true){

            System.out.println("     ----->TEXT list<-----     ");
            System.out.println("Choose What would you like to do: ");
            System.out.println("0. Print Data ");
            System.out.println("1. Insert Data");
            System.out.println("2. Delete Entire Data");
            System.out.println("3. Delete specific line");
            System.out.println("4. Update Specific Line");
            System.out.println("5. Update Word");
            System.out.println("6. Update ALL Lines");
            System.out.println("7. Append Data");
            System.out.println("8. Search By Line");
            System.out.println("9. Search By Word");
            System.out.println("10. UNDO");
            System.out.println("11. REDO");
            System.out.println("12. Create a File");
            System.out.println("13. Save File");
            System.out.println("14. Edit Existing File");
            System.out.println("15. Read File");
            System.out.println("16. Open File");

            System.out.println();
            System.out.println("-----INFO-----");
            System.out.println("Total number of Line Filled: "+ linkedList.lineUsed);
            System.out.println("Make your choice: ");

           int selection = input();

            linkedList list = new linkedList();

            if(selection==0){
                list.printData();
                System.out.println("Process Completed");
            }
            else if(selection==1){

                System.out.println("Enter Data to be Inserted: ");
                String data =  input1();
                list.addDataAtHead(data);
                undo.push(selection);
            }
            else if(selection==2){

                list.deleteEntireData();
                undo.push(selection);
                System.out.println("Process Completed");
            }
            else if(selection==3){
                System.out.println("Enter Line Number: ");
                int line = input();


                list.deleteGivenLine(line);
                arr.add(String.valueOf(line));
//                arr1.add(String.valueOf(line));

                arr.add(value);
                undo.push(selection);

                System.out.println("Process Completed");
            }
            else if(selection==4){

                System.out.println("Enter the number of line: ");
                int lineNo = input();

                System.out.println("Enter Data to be Inserted: ");
                String data =  input1();

                list.updateLine(data, lineNo);
                arr.add(String.valueOf(lineNo));
                arr.add(value);
                undo.push(selection);
                System.out.println("Process Completed");
                System.out.println(arr);
            }
            else if(selection==5){
                System.out.println("Enter Word to SEARCH for: ");
                String word1 =  scan.next();
                System.out.println("Enter Word to SWAP: ");
                String word2 = scan.next();
                arr.add(word1);
                arr.add(word2);
                list.updateWord(word1, word2);
                undo.push(selection);
                System.out.println("Process Completed");

            }
            else if(selection==6){

                System.out.println("Enter Sentence to SEARCH for: ");
                String sen1 =  input1();
                arr.add(sen1);
                System.out.println("Enter Sentence to SWAP: ");
                String sen2 = input1();
                arr.add(sen2);

                list.updateLine2(sen1, sen2);
                undo.push(selection);
                System.out.println("Process Completed");

            }
            else if(selection==7){

                System.out.println("Enter the number of line: ");
                int lineNo = input();
                System.out.println("Enter Data to be Inserted: ");
                String data =  input1();

                list.appendData(data, lineNo);

                arr.add(String.valueOf(lineNo));
                arr.add(value);

                undo.push(selection);
                System.out.println("Process Completed");
            }
            else if(selection==8){

                System.out.println("Enter Data to SEARCH: ");
                String data = input1();
                list.searchByLine(data);
//                undo.push(selection);
                System.out.println("PROCESS FINISHED");

            }
            else if(selection==9){

                System.out.println("Enter Data to SEARCH: ");
                String data = scan.next();
                list.searchByWord(data);
//                undo.push(selection);
                System.out.println("PROCESS FINISHED");

            }
            else if(selection==10){
                if(undo.peek()==1){
                    if(head==null){
                        System.out.println("CAN'T PERFORM");
                    }else {
                        if (head.next == null) {
                            value =  head.data;
                            head = null;
                            tail = null;
                            redo.push(undo.peek());
                            arr1.add(value);
                            undo.pop();
                        } else {
                            value = tail.data;
                            arr1.add(value);
                            Node curNode = tail;
                            Node prev = curNode.prev;
                            prev.next = null;
                            tail = prev;
                            redo.push(undo.peek());
                            undo.pop();
                            linkedList.lineUsed -= 1;
                        }
                    }
                }
                else if(undo.peek()==2){
                    Node curNode =head2;
                    if(head==null) {
                        head = curNode;
                        tail = curNode;
                        head.prev =null;
                        tail.prev = null;
                    }
                    int count= 1;
                    Node Node1 = head;
                    curNode =curNode.next;
                    while(curNode!=null){
                        Node Node2 = new Node(curNode.data);
                        Node2.prev = Node1;
                        Node1.next = Node2;
                        Node1 = Node2;
                        curNode = curNode.next;
                        count++;
                    }
                    tail = Node1;
                    lineUsed = count;
                    redo.push(undo.peek());
                    undo.pop();
                }
                else if(undo.peek()==3){
                    int size =arr.size()-1;
                    int listSize = list.size();
                    if(head==null){
                        String data = arr.get(size);
                        Node newNode = new Node(data);
                        head = newNode;
                        tail = newNode;
                        newNode.prev = null;
                        arr.remove(size);
                        arr.remove(size-1);
                        lineUsed+=1;
                    }else {
                        if(Objects.equals(arr.get(size - 1), "1")){
                            Node newNode =new Node(arr.get(size));
                            Node curNode = head;
                            newNode.next = curNode;
                            curNode.prev =newNode;
                            head= newNode;
                            newNode.prev = null;
                            arr.remove(size);
                            arr.remove(size-1);
                            lineUsed+=1;
                        }else {

                            Node curNode = head;
                            int count = 1;
                            while (count != Integer.parseInt(arr.get(size - 1))) {
                                if (curNode.next == null) {
                                    break;
                                } else {
                                    curNode = curNode.next;
                                }
                                count++;
                            }
                            System.out.println(count);
                            Node prev= curNode.prev;
//                            if(){
//                                Node newNode = new Node(arr.get(size));
//                                Node next = curNode.next;
//                                next.prev = newNode;
//                                newNode.prev = curNode;
//                                curNode.next = newNode;
//                                newNode.next =next;
//                            }
                            if (curNode.next == null ) {
                                Node newNode = new Node(arr.get(size));
                                curNode = tail;
                                curNode.next = newNode;
                                newNode.prev = curNode;
                                tail = newNode;
                                arr.remove(size);
                                arr.remove(size - 1);
                                lineUsed+=1;
                            } else{
                                System.out.println(curNode.data);
//                                Node newNode = new Node(arr.get(size));
//                                Node next = curNode.next;
//                                next.prev = newNode;
//                                newNode.prev = curNode;
//                                curNode.next = newNode;
//                                newNode.next =next;
                            }
                        }

                    }
                    System.out.println(arr);
                    redo.push(undo.peek());
                    undo.pop();
                }
                else if(undo.peek()==4){
                    if(head==null){
                        System.out.println("CAN'T PERFORM");
                    }else{
                        int size = arr.size()-1;
                        Node curNode =head;
                        int line = Integer.parseInt(arr.get(size-1));
                        int count=1;
                        while(count!=line){
                            curNode =curNode.next;
                            count++;
                        }
                        curNode.data = arr.get(size);
                        redo.push(undo.peek());
                        undo.pop();
                        arr.remove(size);
                        arr.remove(size-1);
                    }
                }
                else if(undo.peek()==5) {
                    if (head == null) {
                        System.out.println("CAN'T PERFORM");
                    } else {
                            int size =arr.size()-1;
                            list.updateWord(arr.get(size), arr.get(size-1));
                            arr1.add(arr.get(size-1));
                            arr1.add(arr.get(size));
                            arr.remove(size);
                            arr.remove(size-1);
                            redo.push(undo.peek());
                            undo.pop();
                    }
                }
                else if(undo.peek()==6){
                    int size = arr.size()-1;
                    System.out.println(size);
//                    System.out.println(arr1);
                    if(head==null){
                        System.out.println("CAN'T PERFORM");
                    }else{
                        Node curNode = head;
                        System.out.println(arr.get(size)+" "+arr.get(size-1));
                        while(curNode!=null){
                            if(Objects.equals(curNode.data, arr.get(size))){
                                curNode.data = arr.get(size-1);
                            }
                            curNode= curNode.next;
                        }
                        arr1.add(arr.get(size));
                        arr1.add(arr.get(size-1));
                        arr.remove(size);
                        arr.remove(size-1);
                        redo.push(undo.peek());
                        undo.pop();
                    }

                }
                else if(undo.peek()==7) {

                    int size = arr.size() - 1;
                    if (head == null) {
                        System.out.println("CAN'T PERFORM");
                    } else {
                        Node curNode = head;
                        int count = 1;
                        int line = Integer.parseInt(arr.get(size - 1));

                        while (count != line) {
                            curNode = curNode.next;
                            count++;
                        }
                        String sen = curNode.data;
                        String newString ="";

                        for(int i=0;i<Integer.parseInt(arr.get(size))+1;i++){
                            newString+=sen.charAt(i);
                        }

                        String appendData="";
                        for(int i=newString.length()+1;i<sen.length();i++){
                            appendData+=sen.charAt(i);
                        }

                        arr1.add(String.valueOf(line));
                        arr1.add(appendData);
                        curNode.data = newString;
                        arr.remove(size);
                        arr.remove(size-1);
                }

                    redo.push(undo.peek());
                    undo.pop();

                }
            }
            else if(selection==11){
                if(redo.peek()==1){
                    int size = arr1.size()-1;
                    Node node=  new Node(arr1.get(size));
                    if(head==null){
                        head = node;
                        tail = node;
                        node.prev =null;
                        arr1.remove(size);
                        undo.push(redo.peek());
                        redo.pop();
                    }else{
                        Node newNode = tail;
                        newNode.next = node;
                        node.prev = newNode;
                        tail = node;
                        arr1.remove(size);
                        undo.push(redo.peek());
                        redo.pop();
                    }
                }
                else if(redo.peek()==2){
                    list.deleteEntireData();
                    undo.push(redo.peek());
                    redo.pop();
                }
                else if(redo.peek()==3){
                    if(head==null){
                        System.out.println("CAN'T PERFORM");
                    }else{
                        int size = arr1.size()-1;
                        int line  = Integer.parseInt(arr1.get(size));
                        arr1.remove(size);
                        list.deleteGivenLine(line);
                        undo.push(redo.peek());
                        redo.pop();
                    }
                }
                else if(redo.peek()==4){

                }
                else if(redo.peek()==5){
                    if(head==null){
                        System.out.println("CAN'T PERFORM");
                    }else{
                        int size = arr1.size()-1;
                        list.updateWord(arr1.get(size-1), arr1.get(size));
                        arr.add(arr1.get(size));
                        arr.add(arr1.get(size-1));
                        arr1.remove(size);
                        arr1.remove(size-1);

                        undo.push(redo.peek());
                        redo.pop();
                    }
                }
                else if(redo.peek()==6){
                int size = arr1.size()-1;
                    if(head==null){
                        System.out.println("CAN'T PERFORM");
                    }else{
                        list.updateLine2(arr1.get(size), arr1.get(size-1));
                        arr.add(arr1.get(size));
                        arr.add(arr1.get(size-1));
                        arr1.remove(size);
                        arr1.remove(size-1);
                        undo.push(redo.peek());
                        redo.pop();
                    }
                }
                else if(redo.peek()==7){
                    if(head==null){
                        System.out.println("CAN'T PERFORM");
                    }else{
                        int size = arr1.size()-1;
                        int line = Integer.parseInt(arr1.get(size-1));
                        int count=1;
                        Node curNode =head;
                        while(count!=line){
                            curNode =curNode.next;
                            count++;
                        }
                        String sen = curNode.data;
                        int len = sen.length()-1;
                        list.appendData(arr1.get(size), line);

                        arr.add(arr1.get(size-1));
                        arr.add(String.valueOf(len));
                        arr1.remove(size);
                        arr1.remove(size-1);

                        undo.push(redo.peek());
                        redo.pop();
                    }
                }
            }
            else if(selection==12){
                System.out.println("Enter a Name for your File");
                String fileName = scan.next();
                curFile = fileName;
                fileList.add(fileName);
                File myfile = new File(fileName);

                try {
                    myfile.createNewFile();
                }catch(IOException e){
                    System.out.println("Unable to Create File");
                    e.printStackTrace();
                }
                System.out.println("---File Created Successfully---");
            }
            else if(selection==13){
                FileWriter write = new FileWriter(curFile);
                Node curNode = head;
                try{
                    while(curNode!=null){
                        write.write(curNode.data+"\n");
                        curNode = curNode.next;
                    }
                    write.close();
                }catch(IOException e){
                    System.out.println("Unable to Write");
                    e.printStackTrace();
                }
                System.out.println("---File Saved Successfully---");
                list.deleteEntireData();
            }
            else if(selection==14){
                System.out.println("Which one would you like to open->");
                int count=1;
                for(int i =0;i<fileList.size();i++){
                    System.out.println(count +" "+fileList.get(i));
                    count++;
                }
                System.out.println("Enter a file Name:");
                String fileName = scan.next();
                File myfile = new File(fileName);
                try {
                    Scanner sc = new Scanner(myfile);
                    while(sc.hasNextLine()){
                        String line = sc.nextLine();
                        list.addDataAtHead(line);
                    }
                    sc.close();
                }catch(IOException e){
                    System.out.println("Unable to Read");
                    e.printStackTrace();
                }
                System.out.println("-->Start Editing");
            }
            else if(selection==15){
                list.deleteEntireData();
                System.out.println("Which one would you like to Read->");
                int count=1;
                for(int i =0;i<fileList.size();i++){
                    System.out.println(count +" "+fileList.get(i));
                    count++;
                }

                System.out.println("Enter a file Name:");
                String fileName = scan.next();
                File readFile = new File(fileName);

                try {
                    Scanner sc = new Scanner(readFile);
                    while(sc.hasNextLine()){
                        String line = sc.nextLine();
                        list.addDataAtHead(line);
                    }
                    sc.close();
                }catch(IOException e){
                    System.out.println("Unable to Read");
                    e.printStackTrace();
                }
                list.printData();
            }
            else if(selection==16){
                System.out.println("Which one would you like to Open->");
                int count=1;
                for(int i =0;i<fileList.size();i++){
                    System.out.println(count +" "+fileList.get(i));
                    count++;
                }
                System.out.println("Enter the Name of File to Open");
                String fileName = scan.next();
                try{
                    File file = new File(fileName);
                    if(!Desktop.isDesktopSupported())
                    {
                        System.out.println("not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists())  {
                        desktop.open(file);
                    }
                }catch (Exception e){
                        e.printStackTrace();
                        }
            }
            else{
//                System.out.println(fileList);
//                undo.print();
//                System.out.println(arr1);
//                System.out.println(arr);
                System.out.println("-->NOTE:");
                System.out.println("    THERE IS NO SUCH OPTION PRESENT AT THE TIME.");
            }
        }
    }
}




