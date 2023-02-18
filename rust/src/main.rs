mod _001;
mod _002;
mod math;

fn main() {}

#[cfg(test)]
mod tests {
    use crate::_001::multiples_of_3_or_5;
    use hex_literal::hex;
    use md5::{Digest, Md5};
    use crate::_002::even_fibonacci_numbers;

    fn md5<T: ToString>(d: T) -> Vec<u8> {
        let mut hasher = Md5::new();
        hasher.update(d.to_string());
        hasher.finalize().to_vec()
    }

    #[test]
    fn _001() {
        assert_eq!(
            md5(multiples_of_3_or_5()),
            hex!("e1edf9d1967ca96767dcc2b2d6df69f4")
        );
    }

    #[test]
    fn _002() {
        assert_eq!(
            md5(even_fibonacci_numbers()),
            hex!("4194eb91842c8e7e6df099ca73c38f28")
        )
    }
}
