package com.anish.playquiz;

public class Questions {


    public String mQuestions[] =
            {
                  "Which is highest peak among all?",
                  "Who is president of nepal",
                  "Who is prime minister of nepal",
                  "What is full form of CPU",
                  "Who is CEO of Microsoft"

            };

    private String mChoices[][]=
            {
                    {"Sagarmatha","Annapurna","Manslu","Machapuchre"},
                    {"Bidya Devi Bhandari","KP Oli","Prachanda","No one"},
                    {"Sher Bahadur","Chandra Bahadur","Bhim Bahadur","KP Oli"},
                    {"Central Processing Unit","Central Process Unit","Centre Processor Unit","Central Process Unit"},
                    {"Jeff Bezos","Satya Nadela","Bill Gates","Sundar Pichai"}


            };


    private String mCorrectAnswer[]={"Sagarmatha","Bidya Devi Bhandari","KP Oli","Central Processing Unit","Satya Nadela"};

    public String getQuestions(int a)
    {
        String question=mQuestions[a];
        return question;
    }

    public String getChoice(int a)
    {
        String choice=mChoices[a][0];
        return choice;
    }
    public String getChoice1(int a)
    {
        String choice=mChoices[a][1];
        return choice;
    }
    public String getChoice2(int a)
    {
        String choice=mChoices[a][2];
        return choice;
    }
    public String getChoice3(int a)
    {
        String choice=mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a)
    {
        String answer=mCorrectAnswer[a];
        return answer;
    }

}
