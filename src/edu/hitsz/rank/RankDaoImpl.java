package edu.hitsz.rank;

import edu.hitsz.application.Settings;

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
                System.out.println(rankList);
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
        String path = "src/data/" + Settings.getInstance().getDiff() + "rank";
        List<RankLine> rankLists = new ArrayList<>();
        File file = new File(path);
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
        String path = "src/data/" + Settings.getInstance().getDiff() + "rank";
        File file = new File(path);
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
    public void addAll(List<RankLine> rankLists) throws IOException {
        for(var rankList: rankLists){
            add(rankList);
        }
    }

    @Override
    public boolean remove(RankLine rankLine) throws IOException {
        boolean flag = false;
        List<RankLine> rankLists = getAllRankLists();
        for(int i = 0; i < rankLists.size(); i ++){
            if (rankLists.get(i).getTime().equals(rankLine.getTime())){
                rankLists.remove(i);
                flag = true;
            }
        }
        if(flag){
            rewrite(rankLists);
        }
        return flag;
    }

    @Override
    public boolean deleteByName(String name) throws IOException {
        List<RankLine> rankLists = getAllRankLists();
        boolean flag = rankLists.removeIf(rankList -> {
            rankList.getName().equals(name);
            return true;
        });
        if(flag){
            rewrite(rankLists);
        }
        return flag;
    }

    /**
     * 将结果从高到低排序并且保存到文件中
     */
    @Override
    public void sort() throws IOException {
        List<RankLine> rankLists = getAllRankLists();
        Collections.sort(rankLists);
        rewrite(rankLists);
    }

    @Override
    public boolean deleteByTime(String time) throws IOException {
        boolean flag = false;
        List<RankLine> rankLists = getAllRankLists();
        for(int i = 0; i < rankLists.size(); i ++){
            if(rankLists.get(i).getTime().equals(time)){
                rankLists.remove(i);
                flag = true;
            }
        }
        if(flag){
            rewrite(rankLists);
        }
        return flag;
    }

    @Override
    public void rewrite(List<RankLine> rankLists) throws IOException {
        String path = "src/data/" + Settings.getInstance().getDiff() + "rank";
        File file = new File(path);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("");
        bw.close();
        for(var rankList : rankLists) {
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
        }
    }
}
