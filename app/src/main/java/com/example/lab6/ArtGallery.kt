package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6.ui.theme.Lab6Theme

class ArtGallery : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab6Theme {
        ArtSpace()
    }
}

@Composable
fun ArtSpace() {
    val art1 = R.drawable.anguirus__ver_monsterverse__by_maskottitanium_dfm2j1u
    val art2 = R.drawable.biollante_by_mikegoesgeek_d9x9fiz_414w_2x
    val art3 = R.drawable.legendary_godzilla_by_pyrasterran_dd7gzdt
    val art4 = R.drawable.rodan_2019_the_lord_of_the_volcano_by_misssaber444_ddho0az_414w_2x
    val art5 = R.drawable.destroyah_redesign_by_nobackstreetboys_dadjr9n_414w_2x
    val art6 = R.drawable.godzilla__king_of_the_monsters___burn__baby__burn__by_chimeraic_dd86pmy
    val art7 = R.drawable.kaiju_king__orga_by_gugenheim98_df07bei
    val art8 = R.drawable.the_king_of_terror_by_kaijusamurai_dcunqly_414w_2x
    val art9 = R.drawable.the_metal_god__mechagodzilla_upgrade_by_eatalllot_dcya742_414w_2x
    val art10 = R.drawable.godzilla_rulers_of_earth_japan_collaboration_cover_by_kaijusamurai_dcmsrf1_414w_2x

    var title by remember { mutableIntStateOf(R.string.art1_name) }
    var published by remember { mutableIntStateOf(R.string.art1_year) }
    var author by remember { mutableIntStateOf(R.string.art1_author) }
    var currentArtwork by remember { mutableIntStateOf(art1) }

    Box (modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.concrete_texture),
            contentDescription = "app background",
            contentScale = ContentScale.FillBounds,
            alpha = 0.5F,
            modifier = Modifier.matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            ArtworkDisplay(currentArtwork = currentArtwork)

            Spacer(modifier = Modifier.size(16.dp))

            ArtworkInfo(title = title, year = published, author = author )

            Spacer(modifier = Modifier.size(25.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Previous Button
                Button(
                    onClick = {
                        when (currentArtwork) {
                            art1 -> {
                                currentArtwork = art10
                                title = R.string.art10_name
                                published = R.string.art10_year
                                author = R.string.art10_author
                            }
                            art2 -> {
                                currentArtwork = art1
                                title = R.string.art1_name
                                published = R.string.art1_year
                                author = R.string.art1_author
                            }
                            art3 -> {
                                currentArtwork = art2
                                title = R.string.art2_name
                                published = R.string.art2_year
                                author = R.string.art2_author
                            }
                            art4 -> {
                                currentArtwork = art3
                                title = R.string.art3_name
                                published = R.string.art3_year
                                author = R.string.art3_author
                            }
                            art5 -> {
                                currentArtwork = art4
                                title = R.string.art4_name
                                published = R.string.art4_year
                                author = R.string.art4_author
                            }
                            art6 -> {
                                currentArtwork = art5
                                title = R.string.art5_name
                                published = R.string.art5_year
                                author = R.string.art5_author
                            }
                            art7 -> {
                                currentArtwork = art6
                                title = R.string.art6_name
                                published = R.string.art6_year
                                author = R.string.art6_author
                            }
                            art8 -> {
                                currentArtwork = art7
                                title = R.string.art7_name
                                published = R.string.art7_year
                                author = R.string.art7_author
                            }
                            art9 -> {
                                currentArtwork = art8
                                title = R.string.art8_name
                                published = R.string.art8_year
                                author = R.string.art8_author
                            }
                            art10 -> {
                                currentArtwork = art9
                                title = R.string.art9_name
                                published = R.string.art9_year
                                author = R.string.art9_author
                            }
                        }
                    },
                    colors = with(ButtonDefaults) {
                        buttonColors(
                            Color.DarkGray
                        )
                    },
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 1.dp
                    )
                ) {
                    Text(
                        text = "Previous",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.LightGray
                    )
                }

                // Next Button
                Button(
                    onClick = {
                        when (currentArtwork) {
                            art1 -> {
                                currentArtwork = art2
                                title = R.string.art2_name
                                published = R.string.art2_year
                                author = R.string.art2_author
                            }
                            art2 -> {
                                currentArtwork = art3
                                title = R.string.art3_name
                                published = R.string.art3_year
                                author = R.string.art3_author
                            }
                            art3 -> {
                                currentArtwork = art4
                                title = R.string.art4_name
                                published = R.string.art4_year
                                author = R.string.art4_author
                            }
                            art4 -> {
                                currentArtwork = art5
                                title = R.string.art5_name
                                published = R.string.art5_year
                                author = R.string.art5_author
                            }
                            art5 -> {
                                currentArtwork = art6
                                title = R.string.art6_name
                                published = R.string.art6_year
                                author = R.string.art6_author
                            }
                            art6 -> {
                                currentArtwork = art7
                                title = R.string.art7_name
                                published = R.string.art7_year
                                author = R.string.art7_author
                            }
                            art7 -> {
                                currentArtwork = art8
                                title = R.string.art8_name
                                published = R.string.art8_year
                                author = R.string.art8_author
                            }
                            art8 -> {
                                currentArtwork = art9
                                title = R.string.art9_name
                                published = R.string.art9_year
                                author = R.string.art9_author
                            }
                            art9 -> {
                                currentArtwork = art10
                                title = R.string.art10_name
                                published = R.string.art10_year
                                author = R.string.art10_author
                            }
                            art10 -> {
                                currentArtwork = art1
                                title = R.string.art1_name
                                published = R.string.art1_year
                                author = R.string.art1_author
                            }
                        }
                    },
                    colors = with(ButtonDefaults) {
                        buttonColors(
                            Color.DarkGray
                        )
                    },
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 1.dp
                    )
                ) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.LightGray
                    )
                }
            }
        }
    }

}

@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = Color.Gray)
            .border(width = 10.dp, color = Color.Gray)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            )
    ){
        Image(
            painter = painterResource(currentArtwork),
            contentDescription = "Artwork Image",
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 15.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun ArtworkInfo(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes author: Int
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = Color.Gray)
        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                // Artwork title
                Text(
                    text = stringResource(id = title),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(30, 30, 30),
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    lineHeight = 40.sp
                )

                // Artwork date
                Text(
                    text = "Published on: ${stringResource(id = year)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(10.dp)
                )

                // Artwork artist
                Text(
                    text = "By: ${stringResource(id = author)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
        }
    }
}