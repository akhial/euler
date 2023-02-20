use std::collections::VecDeque;
use std::fs::read_to_string;

/// Convert all roman numbers to their decimal digit representation then convert them back into
/// their optimal roman representation. Keep track of characters saved each time.
pub fn roman_numerals() -> i32 {
    let mut t = 0;
    let r = read_to_string("../res/089_roman.txt").unwrap();
    for l in r.lines() {
        let m = l.chars().count();
        let n = parse_roman(l);
        let s = m - to_roman(n).chars().count();
        t += s as i32;
    }
    t
}

fn parse_roman(s: &str) -> i32 {
    let mut chars: VecDeque<char> = s.chars().collect();
    let mut v = vec![0; 7];
    loop {
        if let Some(c) = chars.pop_front() {
            match c {
                'M' => {
                    v[0] += 1;
                    v[2] *= -1;
                }
                'D' => {
                    v[1] += 1;
                    v[2] *= -1;
                }
                'C' => {
                    v[2] += 1;
                    v[4] *= -1;
                }
                'L' => {
                    v[3] += 1;
                    v[4] *= -1;
                }
                'X' => {
                    v[4] += 1;
                    v[6] *= -1;
                }
                'V' => {
                    v[5] += 1;
                    v[6] *= -1;
                }
                'I' => {
                    v[6] += 1;
                }
                _ => {
                    panic!("Unexpected token: {}", c)
                }
            }
        } else {
            break;
        }
    }
    v[0] * 1000 + v[1] * 500 + v[2] * 100 + v[3] * 50 + v[4] * 10 + v[5] * 5 + v[6]
}

fn to_roman(mut n: i32) -> String {
    let a = n / 1000;
    n -= a * 1000;
    let b = n / 100;
    n -= b * 100;
    let c = n / 10;
    n -= c * 10;

    let mut s = String::new();

    for _ in 0..a {
        s.push('M');
    }
    roman_add_power(&mut s, b, vec!['C', 'D', 'M']);
    roman_add_power(&mut s, c, vec!['X', 'L', 'C']);
    roman_add_power(&mut s, n, vec!['I', 'V', 'X']);

    s
}

fn roman_add_power(s: &mut String, x: i32, chars: Vec<char>) {
    match x {
        1 | 2 | 3 => s.push_str(chars[0].to_string().repeat(x as usize).as_str()),
        4 => s.push_str(&format!("{}{}", chars[0], chars[1])),
        5 => s.push(chars[1]),
        6 | 7 | 8 => s.push_str(&format!(
            "{}{}",
            chars[1],
            chars[0].to_string().repeat((x - 5) as usize)
        )),
        9 => s.push_str(&format!("{}{}", chars[0], chars[2])),
        _ => {}
    }
}

#[cfg(test)]
mod tests {
    use crate::_089::{parse_roman, to_roman};

    #[test]
    fn parse_roman_returns_expected_with_optimal() {
        assert_eq!(parse_roman("MMDCLXXXVI"), 2686);
        assert_eq!(parse_roman("MCMXC"), 1990);
        assert_eq!(parse_roman("MMCDXXI"), 2421);
        assert_eq!(parse_roman("MMMCCCXLIV"), 3344);
    }

    #[test]
    fn parse_roman_returns_expected_with_nonoptimal() {
        assert_eq!(parse_roman("MMMMDCCCCLXXXXVIIII"), 4999);
    }

    #[test]
    #[should_panic(expected = "Unexpected token: H")]
    fn parse_roman_panics_on_unexpected_character() {
        parse_roman("MCMHVI");
    }

    #[test]
    fn to_roman_returns_expected() {
        assert_eq!(to_roman(1990), "MCMXC");
        assert_eq!(to_roman(2788), "MMDCCLXXXVIII");
        assert_eq!(to_roman(4999), "MMMMCMXCIX");
    }
}
