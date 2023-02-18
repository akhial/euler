use std::cmp::max;

pub fn fibonacci(n: usize) -> u64 {
    let mut d = vec![0; max(n + 1, 2)];
    fibonacci_into(n, &mut d)
}

pub fn fibonacci_into(n: usize, d: &mut Vec<u64>) -> u64 {
    d[0] = 0;
    d[1] = 1;

    for i in 2..n + 1 {
        d[i] = d[i - 1] + d[i - 2];
    }

    d[n]
}

#[cfg(test)]
mod tests {
    use crate::math::fibonacci;

    #[test]
    fn fibonacci_returns_expected() {
        assert_eq!(0, fibonacci(0));
        assert_eq!(1, fibonacci(1));
        assert_eq!(1, fibonacci(2));
        assert_eq!(13, fibonacci(7));
        assert_eq!(190_392_490_709_135, fibonacci(70));
    }
}
