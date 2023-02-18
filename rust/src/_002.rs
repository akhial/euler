use crate::math::fibonacci_into;

pub fn even_fibonacci_numbers() -> u64 {
    const MAX: usize = 33;
    let mut d = vec![0; MAX + 1];
    fibonacci_into(MAX, &mut d);
    d.into_iter().filter(|x| x % 2 == 0).sum()
}
