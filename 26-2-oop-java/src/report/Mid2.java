package report;

// 완성
import java.util.StringTokenizer;

public class Mid2 {
	public static void main(String[] args) {
		String sample = new String(
				"Rise in 'lonely deaths'\nOver 3,600 Koreans died home alone in 2023, illustrating depth of social problem\nThe rise in the number of single-person households is hardly surprising in South Korea as the family structure has been shifting in recent decades. However, the spike in the number of those who die alone is alarming in multiple ways.\nThe number of what is called \"lonely deaths\" -- or \"godoksa\" in Korean -- stood at 3,661 in 2023, up from 3,559 the previous year, according to the data released by the Ministry of Health and Welfare.\nThe figure about individuals dying in isolation has risen for three straight years since 2021 when the government began to compile the related data.\nIt is disheartening that those who die alone without the presence of their loved ones is on the rise, even though both the national government and local authorities are making efforts to reverse or slow the trend under the 2021 bill aimed at preventing lonely deaths.\nAccording to the new data, 1.04 out of every 100 deaths in South Korea were solitary deaths last year. Given the steady growth of such deaths, the central government is required to take more prevention initiatives in concert with local administrations and civic organizations.\nThe reason for concerted efforts to curb lonely deaths is obvious. In South Korea, welfare support for retirees is far from sufficient, which drives many elderly people to live in poverty. Even though they suffer from illnesses related to age, they are reluctant or unable to go to hospitals because of the costs.\nThe result is extremely painful deaths that hit those people in isolation in the form of suicide, illnesses or other causes.\nGovernment officials reckon that the growth of single-person households is one of the key reasons behind the unfortunate deaths. The number of one-person families was 7.16 million in 2021, before rising to 7.5 million in 2022 and 7.82 million in 2023.\nLast year, single-person households accounted for 35.5 percent of all households here, a significant share that seems inevitable but comes with problems that deserve attention from the public and policymakers.\nThis explosive social trend should be addressed with proper public funds and programs since over one-third of all households are those who are likely to face social isolation without proper welfare support and confront lonely deaths.\nThe most vulnerable groups are men in their 50s and 60s, accounting for 54.1 percent of total lonely deaths in 2022 and 53.8 percent in 2023. Experts warn that these age groups can easily slip into danger zones when their social and family networks disintegrate rapidly upon retirement or job loss. Provincial governments also cannot regularly check on those in their 50s and 60s who retire and live alone since they are mostly not under the welfare radar yet.\nIn addition, the issue of lonely deaths among young adults should not be overlooked. Although the overall share of lonely deaths is smaller in this demographic compared to other age groups, the proportion of suicides is disturbingly high.\nIn 2022, among all lonely deaths, 14.1 percent of cases were suicides. The figure climbed to 59.5 percent among those in their 20s and 43.4 percent in their 30s. Many of their tragic deaths were reported to be related to difficulties in getting jobs or losing positions at the workplace.\nAmong lonely death victims, 39.7 percent in 2022 and 41.4 percent in 2023 were recipients of basic welfare support from the government. But this suggests that over half of these cases occurred in households not classified as economically vulnerable, and there are more factors other than financial hardship that drive the number of lonely deaths.\nAnybody can face dangerous social isolation when they become old and ill, or jobless and cash-strapped at a time when the traditional closely-knit family structure is collapsing. The government, local authorities and communities should strengthen the social safety net to prevent these tragic deaths.");

		String lowerSample = sample.toLowerCase();
		StringTokenizer st = new StringTokenizer(lowerSample, " ,.'\"-0123456789\n");

		String[] words = new String[st.countTokens()];
		int count = 0;
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			boolean hasA = false;
			boolean hasN = false;
			for (int k = 0; k < token.length(); k++) {
				if (token.charAt(k) == 'a') {
					hasA = true;
				}
				if (token.charAt(k) == 'n') {
					hasN = true;
				}
			}
			if (hasA && hasN) {
				words[count] = token;
				count++;
			}
		}

		for (int i = 0; i < count; i++) {
			System.out.println(words[i]);
		}

		int max = 0;
		for (int i = 0; i < count; i++) {
			if (words[i].length() > max) {
				max = words[i].length();
			}
		}

		System.out.println("철자 수가 가장 많은 단어:");
		for (int i = 0; i < count; i++) {
			if (words[i].length() == max) {
				System.out.println(words[i] + " / " + max + "자");
			}
		}
	}
}