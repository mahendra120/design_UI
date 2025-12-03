@Composable
fun CardCurriculum() {

    data class Curriculum(
        val number: Int,
        val name: String,
        val time: String,
    )

    val curriculumList = listOf(
        Curriculum(1, "Why Using Graphic De..", "15 min"),
        Curriculum(2, "Why Using Graphic De..", "17 min"),
        Curriculum(3, "Why Using Graphic De..", "14 min"),
        Curriculum(4, "Why Using Graphic De..", "10 min"),
    )

    // Header Row
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                        fontFamily = font2,
                        fontSize = 17.sp
                    )
                ) { append("Section 01 - ") }

                withStyle(
                    SpanStyle(
                        color = Color.Blue,
                        fontFamily = font2,
                        fontSize = 17.sp
                    )
                ) { append("Introduction") }
            }
        )

        Text(
            "25 Mins",
            fontSize = 17.sp,
            color = Color.Blue,
            fontFamily = font1
        )
    }

    // List Items
    Column(modifier = Modifier.fillMaxWidth()) {

        curriculumList.forEach { item ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Number Circle
                Card(
                    modifier = Modifier.size(50.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(232, 241, 255)),
                    border = BorderStroke(0.5.dp, Color.Black),
                    shape = RoundedCornerShape(40)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item.number.toString(),
                            fontFamily = font2,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                // Text Box
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(0.5.dp, Color.Black),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = item.name,
                            fontFamily = font2,
                            fontSize = 16.sp
                        )

                        Text(
                            text = item.time,
                            fontFamily = font1,
                            fontSize = 15.sp,
                            color = Color.Blue
                        )
                    }
                }
            }
        }
    }
}
