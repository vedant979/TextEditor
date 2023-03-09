package PROJECT_Text_Editor;

import java.util.Scanner;

public class textEditor {
    private static Node head;
    private static Node tail;
    public static int lineUsed = 0;

    /*---------Defining Node----------*/
    class Node{
        private String data;
        private Node next;
        private Node prev;

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
        Node curNode = head;
        if(curNode.data==""){
            curNode.data = data;
        }
    }

    /*----------Adding Data At TAIL----------*/
    public void addDataToTail(String data){
        Node node  = new Node(data);
        Node newNode = tail;
        newNode.next = node;
        node.prev = newNode;
        tail = node;
        lineUsed+=1;
    }
    /*----------Adding Data in a given LINE----------*/
    public void addDataInGivenLine(String data, int lineNo){
        if(head==null) {
            Node headNode = new Node("");
            head = headNode;
            tail = headNode;
            headNode.prev = null;
            lineUsed++;
//            lineNo--;
        }
        Node curNode = tail;
        while(lineUsed!=lineNo){
            Node newNode = new Node("");
            curNode.next = newNode;
            newNode.prev = curNode;
            curNode = newNode;
            lineUsed+=1;
        }
        tail = curNode;
        curNode.data = data;
    }
    /*----------Adding Data in the MIDDLE----------*/
    public void addDataInMiddle(String data, int lineNo){
        int count=1;
        Node curNode = head;
        while(count!=lineNo){
            curNode = curNode.next;
            count++;
        }
        curNode.data = data;
    }
/*------------------------->END<--------------------------*/

/*------------------------->DELETION<--------------------------*/
    /*----------Deleting given LINE----------*/
    public void deleteGivenLine(int lineNo){
        if(head==null || lineNo>lineUsed || lineNo<0){
            System.out.println("NO DATA TO DELETE");
            return;
        }
        Node curNode = head;
        int count =1;
        while(count!=lineNo){
            curNode=curNode.next;
            count++;
        }
        Node prevNode = curNode.prev;
        prevNode.next = curNode.next;
        lineUsed--;
    }
    /*----------Deleting given LINE----------*/
    public void deleteEntireData() {
        if (head == null) {
            System.out.println("NO DATA TO DELETE");
            return;
        }
        head = null;
        tail = null;
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
        curNode.data = data;
    }
    /*----------Update WORD----------*/
    public void updateWord(String word1,String word2, int lineNo){
        String data="";
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
        data = curNode.data;
        int startPointer= 0;
        String finalS ="";
        String word= "";
        for(int i=0;i<data.length();i++){
            word="";
            if(data.charAt(i)==' '|| i==data.length()-1){
                if(i==data.length()-1){
                    i++;
                }
               for(int j=startPointer;j<i;j++){
                   word+=data.charAt(j);
               }
               if(word.equals(word1)){
                   finalS+=word2;
                   finalS+=" ";
               }else{
                   finalS+=word;
                   finalS+=" ";
               }
               startPointer=i+1;
            }
        }
        curNode.data = finalS;
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
            if(check==1){
                System.out.println("In Line Number: "+count);
            }
            curNode = curNode.next;
            count++;
        }
        System.out.println(">-------------------------<");
    }
    public int findWord(String data, String checkWord){
        int startPointer = 0;
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
                    check = 1;
                    break;
                }
                startPointer = i+1;
            }

        }
        return check;
    }
/*------------------------->END<--------------------------*/
/*------------------------->END<--------------------------*/
    /*----------Append Data----------*/
    public void appendData(String data){
        Node node = new Node(data);
        if(head==null){
            head=node;
            tail=node;
            node.prev = null;
            lineUsed+=1;

            return;
        }
        Node curNode = tail;
        curNode.next = node;
        node.prev = curNode;
        lineUsed+=1;
    }
/*------------------------->END<--------------------------*/

    /*----------Printing Data----------*/

    public static void printData(){
        System.out.println(">-------------------------<");
        if(head==null){
            System.out.println("--No Data to Print--");
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
/*------------------------->END<--------------------------*/

    /*----------Menu Function----------*/
    public static void Menu(int selection){
        textEditor editor = new textEditor();
        Scanner scan = new Scanner(System.in);
        if(selection==0){
            textEditor.printData();
            System.out.println("Process Completed");
        }
        else if(selection==1){
            System.out.println("Enter the number of line: ");
            int lineNo = Integer.parseInt(scan.nextLine());

            System.out.println("Enter Data to be Inserted: ");
            String data =  scan.nextLine();

            if(lineNo==1){
                editor.addDataAtHead(data);
                System.out.println("Process Completed");
            }
            else if(lineNo-1==lineUsed){
                editor.addDataToTail(data);
                System.out.println("Process Completed");
            }
            else if(lineNo<lineUsed){
                editor.addDataInMiddle(data,lineNo);
                System.out.println("Process Completed");
            }
            else{
                editor.addDataInGivenLine(data, lineNo);
                System.out.println("Process Completed");
            }
        }
        else if(selection==2){
            System.out.println("Select: ");
            System.out.println("   1. Delete Entire Data");
            System.out.println("   2. Delete Specific Line");
            int select = scan.nextInt();

            if(select==1){
                editor.deleteEntireData();
                System.out.println("Process Completed");
            }else if(select==2){
                System.out.println("Enter Line Number: ");
                int line = scan.nextInt();
                editor.deleteGivenLine(line);
                System.out.println("Process Completed");
            }else{
                System.out.println("THERE IS NO SUCH OPTION PRESENT AT THE TIME.");
            }
        }
        else if(selection==3){
            System.out.println("Select: ");
            System.out.println("   1.Update Line");
            System.out.println("   2.Update Word");
            int select = Integer.parseInt(scan.nextLine());

            if(select==1){
                System.out.println("Enter the number of line: ");
                int lineNo = Integer.parseInt(scan.nextLine());

                System.out.println("Enter Data to be Inserted: ");
                String data =  scan.nextLine();
                editor.updateLine(data, lineNo);
                System.out.println("Process Completed");
            }
            else if(select==2){
                System.out.println("Enter the number of line: ");
                int lineNo = Integer.parseInt(scan.nextLine());

                System.out.println("Enter Word to SEARCH for: ");
                String word1 =  scan.next();
                System.out.println("Enter Word to SWAP: ");
                String word2 = scan.next();

                editor.updateWord(word1, word2 , lineNo);
                System.out.println("Process Completed");
            }
            else{
                System.out.println("THERE IS NO SUCH OPTION PRESENT AT THE TIME.");
            }
        }
        else if(selection==4){
            System.out.println("Enter Data to be Inserted: ");
            String data =  scan.nextLine();
            editor.appendData(data);
            System.out.println("Process Completed");
        }
        else if(selection==5){
            System.out.println("Select: ");
            System.out.println("   1.Search By Line");
            System.out.println("   2.Search By Word");
            int select = Integer.parseInt(scan.nextLine());
            if(select==1){

                System.out.println("Enter Data to SEARCH: ");
                String data = scan.nextLine();
                editor.searchByLine(data);
                System.out.println("PROCESS FINISHED");
            }
            else if(select==2){
                System.out.println("Enter Data to SEARCH: ");
                String data = scan.next();
                editor.searchByWord(data);
                System.out.println("PROCESS FINISHED");
            }
            else{
                System.out.println("THERE IS NO SUCH OPTION PRESENT AT THE TIME.");
            }
        }
        else{
            System.out.println("-->NOTE:");
            System.out.println("    THERE IS NO SUCH OPTION PRESENT AT THE TIME.");
        }
    }

    /*------Main Function------*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println("     ----->TEXT EDITOR<-----     ");
            System.out.println("Choose What would you like to do: ");
            System.out.println("0. Print Data ");
            System.out.println("1. Insert Data");
            System.out.println("2. Delete Data");
            System.out.println("   1. Delete Entire Data");
            System.out.println("   2. Delete specific line");
            System.out.println("3. Update Data");
            System.out.println("   1.Update Line");
            System.out.println("   2.Update Word");
            System.out.println("4. Append Data");
            System.out.println("5. Search Data");
            System.out.println("   1.Search By Line");
            System.out.println("   2.Search By Word");
            System.out.println("6. UNDO");
            System.out.println("7. REDO");
            System.out.println();
            System.out.println("-----INFO-----");
            System.out.println("Total number of Line Filled: "+lineUsed);
            System.out.println("Make your choice: ");

            int choice  = scan.nextInt();
            Menu(choice);
        }
    }
}




