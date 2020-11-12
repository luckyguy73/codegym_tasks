package com.codegym.task.task23.task2309;

import com.codegym.task.task23.task2309.vo.*;

import java.util.List;

/* 
Sometimes anonymity is so nice!
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static <T> void print(List<T> list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.printf((format) + "%n", item.getId(), item.getName(), item.getDescription());
        }
    }

    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return ("select * from " + "User").toUpperCase();
            }
        }.execute();
    }

    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Location").toUpperCase();
            }
        }.execute();
    }

    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Server").toUpperCase();
            }
        }.execute();
    }

    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Subject").toUpperCase();
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Subscription").toUpperCase();
            }
        }.execute();
    }
}
