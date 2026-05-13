package com.example;
 import java.io.IOException;
 import java.io.PrintWriter;

 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 @WebServlet("/survival")
 public class SurvivalServlet extends HttpServlet {

     @Override
     protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
             throws ServletException, IOException {

         int coffee =
                 Integer.parseInt(request.getParameter("coffee"));

         int sleep =
                 Integer.parseInt(request.getParameter("sleep"));

         int backlog =
                 Integer.parseInt(request.getParameter("backlog"));

         int leetcode =
                 Integer.parseInt(request.getParameter("leetcode"));

         int assessment =
                 Integer.parseInt(request.getParameter("assessment"));



         /*
             SURVIVAL FORMULA
          */

         int score = 50;

          //Sleep effect
         if(sleep >= 7)
             score += 20;
         else if(sleep >= 5)
             score += 10;
         else
             score -= 15;

          //Coffee effect
         if(coffee <= 3)
             score += 10;
         else
             score -= 10;

          //Backlog effect
         score -= backlog * 5;

          //LeetCode effect
         score += leetcode / 10;

          //Assessment effect
         score += assessment * 5;

          //Limit between 0 and 100
         if(score > 100)
             score = 100;

         if(score < 0)
             score = 0;



         String message;

         if(score >= 85){
             message =
               " Placement Cell Wants Your Resume!";
         }
         else if(score >= 65){
             message =
               " You are surviving pretty well!";
         }
         else{
             message =
               " Academic comeback required immediately!";
         }


         response.setContentType("text/html");

         PrintWriter out = response.getWriter();

         out.println("<html>");
         out.println("<head>");
         out.println("<style>");
         out.println("body{");
         out.println("font-family:Arial;");
         out.println("background:black;");
         out.println("color:white;");
         out.println("text-align:center;");
         out.println("padding-top:100px;");
         out.println("}");
         out.println(".card{");
         out.println("width:500px;");
         out.println("margin:auto;");
         out.println("background:#222;");
         out.println("padding:30px;");
         out.println("border-radius:20px;");
         out.println("}");
         out.println(".score{");
         out.println("font-size:60px;");
         out.println("color:#00ff99;");
         out.println("}");
         out.println("</style>");
         out.println("</head>");
         out.println("<body>");
         out.println("<div class='card'>");
         out.println("<h1> ZSGS Survival Report</h1>");
         out.println("<div class='score'>");
         out.println(score + "%");
         out.println("</div>");
         out.println("<h2>");
         out.println(message);
         out.println("</h2>");
         out.println("</div>");
         out.println("</body>");
         out.println("</html>");
     }
 }
