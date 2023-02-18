use crate::math::fibonacci_into;

pub fn even_fibonacci_numbers() -> u64 {
    const MAX_INDEX: usize = 33;
    let mut d = vec![0; MAX_INDEX + 1];
    fibonacci_into(MAX_INDEX, &mut d);
    d.into_iter().filter(|x| x % 2 == 0).sum()
}
