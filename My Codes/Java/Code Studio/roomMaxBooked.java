import java.util.*;

public class roomMaxBooked {

    static String maxRoomBooked(ArrayList<String> arr, int n) {
        if(arr.size()==0){
            return null;
        }

        HashMap<String,Integer> reg=new HashMap<>();
        ArrayList<String> rooms=new ArrayList<>();

        for(int i=0;i<arr.size();++i){
            String st=arr.get(i);
            String room=st.substring(1);

            if(!rooms.contains(room)){
                rooms.add(room);
            }

            if(st.charAt(0)=='+'){
                reg.put(room, 1 + reg.getOrDefault(room, 0));
            }
        }

        String room=rooms.get(0);
        int max_booking=0;

        for(int i=0;i<rooms.size();++i){
            if(reg.get(rooms.get(i))>max_booking){
                max_booking=reg.get(rooms.get(i));
                room=rooms.get(i);
            }
            else if(reg.get(rooms.get(i))==max_booking && (rooms.get(i).compareTo(room))<0){
                max_booking=reg.get(rooms.get(i));
                room=rooms.get(i);
            }
        }

        return room;

    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        ArrayList<String> arr=new ArrayList<>();
        arr.add("+5Q");
        arr.add("-5Q");
        arr.add("+9D");
        arr.add("-9D");
        arr.add("+5Q");
        arr.add("+7I");
        arr.add("+3O");
        arr.add("-5Q");
        
        System.out.print(maxRoomBooked(arr, arr.size()));


        s.close();
    }
}
