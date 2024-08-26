package com.quotejoy.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quotejoy.app.ui.theme.QuoteJoyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteJoyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quote(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Motivational quotes list
val motivationalQuotes = listOf(
    "Dream big, work hard.",
    "Stay positive, work hard, make it happen.",
    "Believe in yourself.",
    "Success is no accident.",
    "Failure is not the end.",
    "You can do it!",
    "Be the change you wish to see.",
    "Keep going, keep growing.",
    "Hard work pays off.",
    "Success is earned, not given.",
    "Push yourself, because no one else will.",
    "Consistency is key.",
    "You are stronger than you think.",
    "Don’t stop until you’re proud.",
    "Your only limit is you.",
    "Make today count.",
    "You’re capable of amazing things.",
    "Don’t give up, great things take time.",
    "Stay focused and never give up.",
    "Make your own luck.",
    "Take the risk or lose the chance.",
    "Small steps every day.",
    "Your attitude determines your direction.",
    "Believe you can and you’re halfway there.",
    "Focus on the good.",
    "Dream it, believe it, achieve it.",
    "Good things come to those who hustle.",
    "Be fearless in the pursuit of what sets your soul on fire.",
    "You are what you do, not what you say you’ll do.",
    "Your life is as good as your mindset.",
    "Be the best version of yourself.",
    "The best is yet to come.",
    "Success is the best revenge.",
    "Be a warrior, not a worrier.",
    "What we think, we become.",
    "Wake up with determination.",
    "No pressure, no diamonds.",
    "Your future is created by what you do today.",
    "Do something today that your future self will thank you for.",
    "You’re closer than you think.",
    "Strive for progress, not perfection.",
    "Success is a journey, not a destination.",
    "Great things never come from comfort zones.",
    "Start where you are, use what you have, do what you can.",
    "Your dreams don’t work unless you do.",
    "The harder you work, the luckier you get.",
    "Action is the foundational key to success.",
    "Success is not for the lazy.",
    "Don’t watch the clock; do what it does. Keep going.",
    "It’s never too late to start.",
    "Don’t be afraid to fail; be afraid not to try.",
    "The best view comes after the hardest climb.",
    "Do what is right, not what is easy.",
    "Stay humble, work hard, be kind.",
    "Set your goals high and don’t stop till you get there.",
    "Never give up on a dream just because of the time it will take to accomplish it.",
    "Believe in your dreams and they may come true; believe in yourself and they will come true.",
    "Don’t count the days, make the days count.",
    "Your mindset determines your success.",
    "Opportunities don’t happen, you create them.",
    "Success is not final, failure is not fatal: It is the courage to continue that counts.",
    "Do what you can, with what you have, where you are.",
    "You can’t start the next chapter of your life if you keep re-reading the last one.",
    "Don’t limit your challenges, challenge your limits.",
    "You were born to be real, not to be perfect.",
    "The only way to do great work is to love what you do.",
    "You don’t have to be perfect to be amazing.",
    "It’s going to be hard, but hard does not mean impossible.",
    "You are capable of more than you know.",
    "The secret to getting ahead is getting started.",
    "You miss 100% of the shots you don’t take.",
    "Be stronger than your excuses.",
    "You are your only limit.",
    "Keep your eyes on the stars and your feet on the ground.",
    "If you can dream it, you can achieve it.",
    "You get what you work for, not what you wish for.",
    "Success is the sum of small efforts repeated day in and day out.",
    "If you want something you’ve never had, you have to do something you’ve never done.",
    "Focus on being productive instead of busy.",
    "Success is the result of preparation, hard work, and learning from failure.",
    "You don’t have to see the whole staircase, just take the first step.",
    "Stay hungry, stay foolish.",
    "The only limit to our realization of tomorrow is our doubts of today.",
    "What you do today can improve all your tomorrows.",
    "The best way to predict the future is to create it.",
    "Don’t wish for it, work for it.",
    "Don’t wait for opportunity, create it.",
    "Make each day your masterpiece.",
    "Success is doing ordinary things extraordinarily well.",
    "The harder the struggle, the more glorious the triumph.",
    "Do something today that your future self will thank you for.",
    "The only way to achieve the impossible is to believe it is possible."
)

// Humors quotes list
val humorousQuotes = listOf(
    "I'm on a whiskey diet. I've lost three days already.",
    "I'm not arguing, I'm just explaining why I'm right.",
    "I’m not lazy, I’m on energy-saving mode.",
    "I could agree with you, but then we’d both be wrong.",
    "Life is short. Smile while you still have teeth.",
    "My bed is a magical place where I suddenly remember everything I forgot to do.",
    "I'm not weird, I'm limited edition.",
    "I'm on a seafood diet. I see food, and I eat it.",
    "Why don’t skeletons fight each other? They don’t have the guts.",
    "I'm not great at the advice. Can I interest you in a sarcastic comment?",
    "I’m not short, I’m concentrated awesome.",
    "Why don’t some couples go to the gym? Because some relationships don’t work out.",
    "I don’t need a hair stylist, my pillow gives me a new hairstyle every morning.",
    "I’m on a 30-day diet. So far, I’ve lost 15 days.",
    "I’m multitasking: I can listen, ignore, and forget all at the same time.",
    "I told my computer I needed a break, now it won’t stop sending me Kit-Kats.",
    "I’m on a roll! Butter me up and call me a biscuit.",
    "If Cinderella’s shoe fit perfectly, why did it fall off?",
    "Why don’t scientists trust atoms? Because they make up everything.",
    "I don’t sweat—I sparkle.",
    "My favorite exercise is a cross between a lunge and a crunch. I call it lunch.",
    "I’m not clumsy, I’m just on a secret mission to test gravity.",
    "I would lose weight, but I hate losing.",
    "Why don’t eggs tell jokes? They’d crack each other up.",
    "I’m not procrastinating. I’m just delaying productivity in an organized manner.",
    "I’m not a complete idiot, some parts are missing.",
    "I'm reading a book about anti-gravity. It's impossible to put down.",
    "I’m not saying I’m Batman, but have you ever seen us in the same room?",
    "I don’t trip over things, I do random gravity checks.",
    "I don’t go crazy. I am crazy. I just go normal from time to time.",
    "My brain has too many tabs open.",
    "If we’re not supposed to have midnight snacks, why is there a light in the fridge?",
    "I’m not lazy, I’m just very relaxed.",
    "I didn’t fall, I’m just spending some quality time with the floor.",
    "I’m not arguing, I’m just passionately expressing my point of view.",
    "If you think nobody cares if you’re alive, try missing a couple of payments.",
    "Why don’t you ever see elephants hiding in trees? Because they’re so good at it.",
    "I’m not aging, I’m becoming a classic.",
    "Why was the math book sad? It had too many problems.",
    "I told my wife she should embrace her mistakes... she gave me a hug.",
    "I'm on a new diet. I don’t eat after 6 AM.",
    "I don’t make mistakes; I create spontaneous data.",
    "I’m not lazy, I’m just in energy-saving mode.",
    "Why did the scarecrow win an award? He was outstanding in his field.",
    "I’m not arguing, I’m just explaining why I’m correct.",
    "Why do cows have hooves instead of feet? Because they lactose.",
    "I’m not messy, I’m just creatively organized.",
    "If at first, you don’t succeed, skydiving is not for you.",
    "I’m not fat, I’m just easier to see.",
    "Why don’t oysters donate to charity? Because they are shellfish.",
    "I’m not crazy, my reality is just different than yours.",
    "I’m on a whiskey diet. I've lost three days already.",
    "If life gives you lemons, make lemonade... and then find someone whose life gave them vodka.",
    "I’m not sleeping, I’m just resting my eyes.",
    "I’m not lazy, I’m on energy-saving mode.",
    "I don’t need Google. My wife knows everything.",
    "Why don’t skeletons fight each other? They don’t have the guts.",
    "I’m not arguing, I’m just explaining why I’m right.",
    "I’m not short, I’m just concentrated awesome.",
    "Why don’t scientists trust atoms? Because they make up everything.",
    "I’m on a 30-day diet. So far, I’ve lost 15 days.",
    "I’m not great at the advice. Can I interest you in a sarcastic comment?",
    "I don’t go looking for trouble; trouble usually finds me first.",
    "Why don’t eggs tell jokes? They’d crack each other up.",
    "I’m not clumsy, I’m just testing gravity.",
    "I’m not arguing, I’m just explaining why I’m right.",
    "Why don’t elephants use computers? They’re afraid of the mouse.",
    "I’m not aging, I’m marinating.",
    "Why was the math book sad? It had too many problems.",
    "I don’t need a hair stylist, my pillow gives me a new hairstyle every morning.",
    "I’m not lazy, I’m just on energy-saving mode.",
    "I’m not a complete idiot, some parts are missing.",
    "Why don’t oysters donate to charity? Because they are shellfish.",
    "I’m not weird, I’m limited edition.",
    "Why don’t skeletons fight each other? They don’t have the guts.",
    "I’m on a seafood diet. I see food, and I eat it.",
    "Why don’t some couples go to the gym? Because some relationships don’t work out.",
    "I don’t need a hair stylist, my pillow gives me a new hairstyle every morning.",
    "I’m not saying I’m Batman, but have you ever seen us in the same room?",
    "Why don’t cows wear shoes? Because they lactose.",
    "I’m not arguing, I’m just passionately expressing my point of view.",
    "Why don’t elephants use computers? They’re afraid of the mouse.",
    "I’m on a roll! Butter me up and call me a biscuit.",
    "I don’t need therapy, I just need more coffee.",
    "I’m not lazy, I’m just in energy-saving mode.",
    "I’m not procrastinating. I’m just delaying productivity.",
    "I’m on a 30-day diet. So far, I’ve lost 15 days.",
    "I’m not arguing, I’m just explaining why I’m right.",
    "I’m not lazy, I’m just very relaxed.",
    "Why don’t oysters donate to charity? Because they are shellfish.",
    "I’m not aging, I’m marinating.",
    "I don’t go looking for trouble; trouble usually finds me first.",
    "Why was the math book sad? It had too many problems."
)


// Lists combining
val listCombination = motivationalQuotes + humorousQuotes

// Custom color
fun customColor(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}

val deepRick = customColor("#5d4c3a")
val offWhite = customColor("#f4f1eb")
val lighterShade = customColor("#6e5e4e")

@Composable
fun Quote(modifier: Modifier) {

    var quotes by rememberSaveable { mutableStateOf("Click 'Generate' to get a quote!") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 40.dp, end = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box()
                {
                    Text(
                        quotes,
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp,
                        fontFamily = FontFamily.Monospace,
                        lineHeight = 50.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = deepRick,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.LightGray,
                                offset = Offset(3f, 3f),
                                blurRadius = 2f
                            )
                        )
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(bottom = 56.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        if (listCombination.isNotEmpty()) {
                            quotes = listCombination.random()
                        }
                    },
                    Modifier
                        .height(56.dp)
                        .padding(horizontal = 16.dp)
                        .border(
                            width = 3.dp,
                            color = lighterShade,
                            shape = RoundedCornerShape(24.dp)
                        ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 12.dp,
                        pressedElevation = 16.dp,
                        hoveredElevation = 14.dp,
                        focusedElevation = 14.dp,
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = deepRick,
                        contentColor = offWhite,
                        disabledContentColor = offWhite,
                        disabledContainerColor = deepRick
                    )
                ) {
                    Text(
                        "Generate Quote",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}