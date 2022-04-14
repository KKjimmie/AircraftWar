package edu.hitsz.rank;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 柯嘉铭
 */
public class RankDaoImpl implements RankDao {
    public RankDaoImpl() {
    }

    @Override
    public void findByName(String name) throws IOException {
        AtomicBoolean find = new AtomicBoolean(false);
        List<RankLine> rankLists = getAllRankLists();
        rankLists.forEach(rankList -> {
            if (Objects.equals(rankList.getName(), name)){
                find.set(true);
                System.out.println(rankList.toString());
            }
        });
        if(!find.get()) {
            System.out.println("There is no data under this user name!");
        }
    }

    @Override
    public void findTop() throws IOException {
        sort();
        List<RankLine> rankLists = getAllRankLists();
        RankLine rankList = rankLists.get(0);
        System.out.println(rankList.toString());
    }

    @Override
    public List<RankLine> getAllRankLists() throws IOException {
        List<RankLine> rankLists = new ArrayList<>();
        File file = new File("src/data/rank");
        if(! file.exists()){
            return null;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        /*
        解析排行榜中一行数据
         */
        while ((str = br.readLine()) != null){
            String[] result = str.split(",");
            String name = result[0];
            int score = Integer.parseInt(result[1]);
            String time = result[2];
            rankLists.add(new RankLine(name, score, time));
        }
        br.close();
        return rankLists;
    }

    @Override
    public void add(RankLine rankList) throws IOException {
        File file = new File("src/data/rank");
        if(! file.exists()){
            file.createNewFile();
        }
       BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(rankList.toString()+"\n");
            bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bw != null){
                try{
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        sort();
    }

    @Override
    public void deleteByName(String name) throws IOException {
        List<RankLine> rankLists = getAllRankLists();
        rankLists.forEach(rankList -> {
            if (Objects.equals(rankList.getName(), name)){
                rankLists.remove(rankList);
            }
        });
    }

    /**
     * 将结果从高到低排序并且保存到文件中
     */
    @Override
    public void sort() throws IOException {
        List<RankLine> rankLists = getAllRankLists();
        Collections.sort(rankLists);
        File file = new File("src/data/rank");
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter(file));
        BufferedWriter finalBw = bw;
        rankLists.forEach((rankLine -> {
            try {
                finalBw.write(rankLine.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                finalBw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}
