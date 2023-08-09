package programmers.level2.pm42888;

import java.util.*;

class User{
    String nickname;

    public User(String nickname){
        this.nickname = nickname;
    }
}

class History{
    String command;
    String uid;

    public History(String command, String uid){
        this.command = command;
        this.uid = uid;
    }
}

public class Solution {
    public String[] solution(String[] record) {
        Map<String, User> userMap = new HashMap<>(); // uid, User
        Queue<History> queue = new LinkedList<>();

        for(int i=0;i<record.length;i++){
            String[] str = record[i].split(" ");
            String command = str[0];
            String uid = str[1];
            String nickname = null;
            if(!command.equals("Leave")){
                nickname = str[2];
            }

            if(command.equals("Enter")){
                // 1. 처음 입장한 사람이 아니라면
                if(userMap.containsKey(uid)){
                    // 1-1. 닉네임이 바꼈다면
                    if(!userMap.get(uid).nickname.equals(nickname)){
                        userMap.get(uid).nickname = nickname;
                    }
                }
                // 2. 처음 입장한 사람이라면
                else{
                    userMap.put(uid, new User(nickname));
                }

                queue.add(new History(command, uid));
            } else if(command.equals("Leave")){
                queue.add(new History(command, uid));
            }
            else if(command.equals("Change")){
                userMap.get(uid).nickname = nickname;
            }
        }

        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()){
            History history = queue.poll();
            String command = history.command;
            String uid = history.uid;
            User user = userMap.get(uid);

            if(command.equals("Enter")){
                list.add(user.nickname+"님이 들어왔습니다.");
            } else{
                list.add(user.nickname+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
