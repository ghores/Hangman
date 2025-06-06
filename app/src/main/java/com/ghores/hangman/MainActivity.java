package com.ghores.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String wordDashed;
    private int failCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String word = selectWord();
        wordDashed = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                wordDashed += "-";
            } else {
                wordDashed += " ";
            }
        }

        ImageView img_face = findViewById(R.id.img_face);
        img_face.setImageResource(R.drawable.face_1);

        TextView txt_word = findViewById(R.id.txt_word);
        txt_word.setText(wordDashed);

        TextView txt_a = findViewById(R.id.txt_a);
        TextView txt_b = findViewById(R.id.txt_b);
        TextView txt_c = findViewById(R.id.txt_c);
        TextView txt_d = findViewById(R.id.txt_d);
        TextView txt_e = findViewById(R.id.txt_e);
        TextView txt_f = findViewById(R.id.txt_f);
        TextView txt_g = findViewById(R.id.txt_g);
        TextView txt_h = findViewById(R.id.txt_h);
        TextView txt_i = findViewById(R.id.txt_i);
        TextView txt_j = findViewById(R.id.txt_j);
        TextView txt_k = findViewById(R.id.txt_k);
        TextView txt_l = findViewById(R.id.txt_l);
        TextView txt_m = findViewById(R.id.txt_m);
        TextView txt_n = findViewById(R.id.txt_n);
        TextView txt_o = findViewById(R.id.txt_o);
        TextView txt_p = findViewById(R.id.txt_p);
        TextView txt_q = findViewById(R.id.txt_q);
        TextView txt_r = findViewById(R.id.txt_r);
        TextView txt_s = findViewById(R.id.txt_s);
        TextView txt_t = findViewById(R.id.txt_t);
        TextView txt_u = findViewById(R.id.txt_u);
        TextView txt_v = findViewById(R.id.txt_v);
        TextView txt_w = findViewById(R.id.txt_w);
        TextView txt_x = findViewById(R.id.txt_x);
        TextView txt_y = findViewById(R.id.txt_y);
        TextView txt_z = findViewById(R.id.txt_z);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view;
                String id = textView.getResources().getResourceEntryName(textView.getId());
                String letter = id.replace("txt_", "");
                char letterChar = letter.charAt(0);
                Log.i("test", "text view clicked " + letter);

                String toLowerCase = word.toLowerCase();
                if (toLowerCase.contains(letter)) {
                    Log.i("test", "word contains " + letter);
                    for (int i = 0; i < toLowerCase.length(); i++) {
                        if (toLowerCase.charAt(i) == letterChar) {
                            char[] wordDashedCharArray = wordDashed.toCharArray();
                            wordDashedCharArray[i] = letterChar;
                            wordDashed = new String(wordDashedCharArray);
                            txt_word.setText(wordDashed);
                            Log.i("test", " Found at index " + i);
                            if (!wordDashed.contains("-")) {
                                Intent intent = new Intent(MainActivity.this, FinishActivity.class);
                                intent.putExtra("result", "WON");
                                MainActivity.this.startActivity(intent);
                                finish();
                                Log.i("test", "Game won");
                                return;
                            }
                        }
                    }
                } else {
                    Log.i("test", "word not contains " + letter);
                    failCount++;
                    if (failCount >= 8) {
                        img_face.setImageResource(R.drawable.face_9);
                        Intent intent = new Intent(MainActivity.this, FinishActivity.class);
                        intent.putExtra("result", "LOST");
                        MainActivity.this.startActivity(intent);
                        finish();
                        Log.i("test", "Game over " + failCount);
                        return;
                    }
                    int imageId = R.drawable.face_1;
                    switch (failCount) {
                        case 1: imageId = R.drawable.face_2;break;
                        case 2: imageId = R.drawable.face_3;break;
                        case 3: imageId = R.drawable.face_4;break;
                        case 4: imageId = R.drawable.face_5;break;
                        case 5: imageId = R.drawable.face_6;break;
                        case 6: imageId = R.drawable.face_7;break;
                        case 7: imageId = R.drawable.face_8;break;
                        case 8: imageId = R.drawable.face_9;break;
                    }
                    img_face.setImageResource(imageId);
                }
                textView.setVisibility(View.INVISIBLE);
            }
        };
        txt_a.setOnClickListener(listener);
        txt_b.setOnClickListener(listener);
        txt_c.setOnClickListener(listener);
        txt_d.setOnClickListener(listener);
        txt_e.setOnClickListener(listener);
        txt_f.setOnClickListener(listener);
        txt_g.setOnClickListener(listener);
        txt_h.setOnClickListener(listener);
        txt_i.setOnClickListener(listener);
        txt_j.setOnClickListener(listener);
        txt_k.setOnClickListener(listener);
        txt_l.setOnClickListener(listener);
        txt_m.setOnClickListener(listener);
        txt_n.setOnClickListener(listener);
        txt_o.setOnClickListener(listener);
        txt_p.setOnClickListener(listener);
        txt_q.setOnClickListener(listener);
        txt_r.setOnClickListener(listener);
        txt_s.setOnClickListener(listener);
        txt_t.setOnClickListener(listener);
        txt_u.setOnClickListener(listener);
        txt_v.setOnClickListener(listener);
        txt_w.setOnClickListener(listener);
        txt_x.setOnClickListener(listener);
        txt_y.setOnClickListener(listener);
        txt_z.setOnClickListener(listener);
    }
    private String selectWord() {
        String[] words = {
                "Object Oriented",
                "Polymorphism",
                "Encapsulation",
                "Interface",
                "Composition",
                "Android",
                "Development",
                "Programming",
                "Design",
                "Research",
                "Google",
                "Refactoring",
                "Renaming",
                "Documentation",
        };
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
}