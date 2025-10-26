package heaps.lec3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter
{

    Map<Integer, List<int[]>> tweets;
    // Map to store who follows whom
    Map<Integer, Set<Integer>> following;
    // Time counter to give each tweet a unique timestamp
    int time;

    // Constructor to initialize the system
    public Twitter()
    {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    // Function to post a new tweet
    public void postTweet(int userId, int tweetId)
    {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] {time++, tweetId});
    }

    // Function to retrieve 10 most recent tweet IDs in the news feed
    public List<Integer> getNewsFeed(int userId)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add own tweets
        if (tweets.containsKey(userId))
        {
            for (int[] tweet : tweets.get(userId))
            {
                pq.offer(tweet);
                if (pq.size() > 10)
                {
                    pq.poll();
                }
            }
        }

        // Add tweets from followed users
        if (following.containsKey(userId))
        {
            for (int followee : following.get(userId))
            {
                if (tweets.containsKey(followee))
                {
                    for (int[] tweet : tweets.get(followee))
                    {
                        pq.offer(tweet);
                        if (pq.size() > 10)
                        {
                            pq.poll();
                        }
                    }
                }
            }
        }

        // Retrieve tweets in reverse order
        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty())
        {
            res.addFirst(pq.poll()[1]);
        }
        return res;
    }

    // Function to follow another user
    public void follow(int followerId, int followeeId)
    {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    // Function to unfollow another user
    public void unfollow(int followerId, int followeeId)
    {
        if (following.containsKey(followerId))
        {
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */