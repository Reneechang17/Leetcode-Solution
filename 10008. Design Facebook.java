import java.util.*;

class Facebook {
    private int time;
    // userId -> List of [postContent, time]
    private Map<Integer, List<String[]>> userPosts;
    // userId -> friendIds
    private Map<Integer, Set<Integer>> friends;

    public Facebook() {
        time = 0;
        userPosts = new HashMap<>();
        friends = new HashMap<>();
    }

    public void writePost(int userId, String postContent) {
        if (!userPosts.containsKey(userId)) {
            userPosts.put(userId, new ArrayList<>());
        }
        userPosts.get(userId).add(new String[] { postContent, String.valueOf(time++) });
    }

    public void addFriend(int user1, int user2) {
        if (user1 == user2)
            return;

        if (!friends.containsKey(user1)) {
            friends.put(user1, new HashSet<>());
        }
        friends.get(user1).add(user2);

        if (!friends.containsKey(user2)) {
            friends.put(user2, new HashSet<>());
        }
        friends.get(user2).add(user1);
    }
    
    public List<String> showPosts(int userId) {
        if (!friends.containsKey(userId)) {
            return new ArrayList<>();
        }

        Set<Integer> friendIds = friends.get(userId);
        if (friendIds.isEmpty()) {
            return new ArrayList<>();
        }

        List<String[]> allPosts = new ArrayList<>();
        
        for (int friend : friendIds) {
            if (userPosts.containsKey(friend)) {
                List<String[]> posts = userPosts.get(friend);
                allPosts.addAll(posts);
            }
        }

        Collections.sort(allPosts, new Comparator<String[]>() {
            public int compare(String[] a, String[] b) {
                int timeA = Integer.parseInt(a[1]);
                int timeB = Integer.parseInt(b[1]);
                return timeB - timeA;
            }
        });

        List<String> res = new ArrayList<>();
        for (String[] post : allPosts) {
            res.add(post[0]);
        }
        return res;
    }
}
