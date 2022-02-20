package com.coen352.assignment3Test;

import com.coen352.assignment3.CourseGraph;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {
    static final int UNVISITED = 0;
    static final int VISITED = 1;

    @Test
    public void testGetPrerequisitePath() throws IOException {
        BufferedReader f;
        f = new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
        CourseGraph G = new CourseGraph();
        createGraph(f, G);
        assertEquals("COEN212 COEN243 MATH204 COEN231 ENGR290 COEN352 COEN311 COEN390 ENGR371 ENGR301 SOEN341 COEN490 ", G.getPrerequisitePath("COEN490"), "Pre-requisite invalid");
        assertEquals("COEN212 COEN243 MATH204 COEN231 COEN352 COEN311 COEN346 COEN320 ", G.getPrerequisitePath("COEN320"), "Pre-requisite invalid");
    }

    @Test
    public void testGetPrerequisite() throws IOException {
        BufferedReader f;
        f = new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
        CourseGraph G = new CourseGraph();
        createGraph(f, G);
        assertArrayEquals( new String[]{"COEN212", "COEN231"}, G.getPrerequisite("COEN313"), "Pre-requisite invalid");
        assertArrayEquals( new String[]{"SOEN341", "ENGR301", "ENGR371", "COEN390"}, G.getPrerequisite("COEN490"), "Pre-requisite invalid");
    }

    static CourseGraph createGraph(BufferedReader file, CourseGraph G) throws IOException
    {
        String line = null;
        StringTokenizer token;
        boolean undirected = false;
        int i, v1, v2, weight;
        String v1String, v2String;

        v1 = 0;
        v2 = 0;

        assert (line = file.readLine()) != null :
                "Error reading number";
        while(line.charAt(0) == '#')
            assert (line = file.readLine()) != null :
                    "Error reading number";
        token = new StringTokenizer(line);
        int n = Integer.parseInt(token.nextToken());
        G.Init(n);
        for (i=0; i<n; i++)
            G.setMark(i, UNVISITED);
        assert (line = file.readLine()) != null :
                "Error reading graph type";
        if (line.charAt(0) == 'U')
            undirected = true;
        else if (line.charAt(0) == 'D')
            undirected = false;
        else assert false : "Bad graph type: " + line;

        while((line = file.readLine()) != null) {
            token = new StringTokenizer(line);
            v1String = token.nextToken();
            v2String = token.nextToken();
            try {
                v1 = getIndex(v1String);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                v2 = getIndex(v2String);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (token.hasMoreTokens())
                weight = Integer.parseInt(token.nextToken());
            else
                weight = 1;
            G.setEdge(v1, v2, weight);
            if (undirected)
                G.setEdge(v2, v1, weight);

            G.courses[v1] = v1String;
            G.courses[v2] = v2String;
        }
        return G;
    }

    public static int getIndex(String course) throws Exception {
        int index;
        switch (course)
        {
            case "MATH204":
                index = 0;
                break;

            case "COEN243":
                index = 1;
                break;

            case "COEN212":
                index = 2;
                break;

            case "COEN231":
                index = 3;
                break;

            case "COEN311":
                index = 4;
                break;

            case "COEN313":
                index = 5;
                break;

            case "COEN346":
                index = 6;
                break;

            case "COEN352":
                index = 7;
                break;

            case "ENGR290":
                index = 8;
                break;

            case "ELEC311":
                index = 9;
                break;

            case "COEN317":
                index = 10;
                break;

            case "COEN320":
                index = 11;
                break;

            case "SOEN341":
                index = 12;
                break;

            case "ELEC372":
                index = 13;
                break;

            case "COEN244":
                index = 14;
                break;

            case "COEN366":
                index = 15;
                break;

            case "ENGR301":
                index = 16;
                break;

            case "ENGR371":
                index = 17;
                break;

            case "COEN390":
                index = 18;
                break;

            case "COEN466":
                index = 19;
                break;

            case "COEN451":
                index = 20;
                break;

            case "COEN316":
                index = 21;
                break;

            case "COEN413":
                index = 22;
                break;

            case "COEN424":
                index = 23;
                break;

            case "COEN432":
                index = 24;
                break;

            case "COEN434":
                index = 25;
                break;

            case "COEN415":
                index = 26;
                break;

            case "COEN433":
                index = 27;
                break;

            case "COEN421":
                index = 28;
                break;

            case "COEN447":
                index = 29;
                break;

            case "COEN422":
                index = 30;
                break;

            case "COEN448":
                index = 31;
                break;

            case "COEN490":
                index = 32;
                break;

            case "COEN446":
                index = 33;
                break;

            default:
                System.out.println(course);
                throw new Exception("Invalid course");
        }
        return index;
    }
}
